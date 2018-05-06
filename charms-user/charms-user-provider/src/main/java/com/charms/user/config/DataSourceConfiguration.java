package com.charms.user.config;


import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration("DataSourceConfiguration")
@AutoConfigureOrder(1)
@ConfigurationProperties(prefix = "spring")
public class DataSourceConfiguration {
    private static final Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class);
    @Value("datasource.type")
    private Class<? extends DataSource> dataSourceType;

    Map<String,DataSource> readDataSourceMap = new HashMap<String, DataSource>();
    private PropertyValues dataSourcePropertyValues;
    private ConversionService conversionService = new DefaultConversionService();

    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.write")
    public DataSource writeDataSource(@Qualifier("wallFilter")WallFilter wfilter){
        DataSource dataSource = DataSourceBuilder.create().type(dataSourceType).build();
        if (dataSource instanceof DruidDataSource) {
            dataSource = (DruidDataSource) dataSource;
            List<Filter> filters = new ArrayList<Filter>();
            filters.add(wfilter);
            ((DruidDataSource) dataSource).setProxyFilters(filters);
        }

        return dataSource;
    }


    @Bean(name = "readDataSources")
    public Map<String,DataSource> readDataSources(Environment env){
        initCustomDataSources(env);

        return readDataSourceMap;
    }


    private void initCustomDataSources(Environment env){
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env,"datasource.reads.");
        String readNames = propertyResolver.getProperty("names");
        Preconditions.checkNotNull(readNames,"read datasource names can not be null");
        for(String readName : readNames.split(",")){
            Map<String,Object> dsMap = propertyResolver.getSubProperties(readName);
            DataSource ds = buildDataSource(dsMap);
            if(ds != null){
                bindData(ds,env);
                readDataSourceMap.put(readName,ds);
            }
        }
    }

    @Primary
    @Bean(name = "wallConfig")
    public WallConfig wallFilterConfig(){
        WallConfig wc = new WallConfig();
        wc.setMultiStatementAllow(true);

        return wc;
    }

    @Primary
    @Bean(name ="wallFilter")
    @DependsOn("wallConfig")
    WallFilter wallFilter(@Qualifier("wallConfig")WallConfig wallConfig){
        WallFilter wf = new WallFilter();
        wf.setConfig(wallConfig);

        return wf;
    }

    public DataSource buildDataSource(Map<String,Object> dsMap){
        try{
            String driverClassName = dsMap.get("driver-class-name").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).type(dataSourceType);
            return factory.build();
        }catch (Exception e){
            log.info("build one data source exception {}",e);
        }

        return null;
    }

    private void bindData(DataSource dataSource,Environment env){
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreNestedProperties(false);
        dataBinder.setIgnoreUnknownFields(true);
        if(dataSourcePropertyValues == null){
            Map<String,Object> rpr = new RelaxedPropertyResolver(env,"datasource.reads").getSubProperties(".");
            Map<String,Object> values = new HashMap<String,Object>(rpr);
            values.remove("type");
            values.remove("driverClassName");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }

}
