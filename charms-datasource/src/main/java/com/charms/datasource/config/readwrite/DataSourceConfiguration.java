package com.charms.datasource.config.readwrite;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.charms.datasource.constants.DataSourceConfig;
import lombok.extern.slf4j.Slf4j;
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

@Slf4j
@Configuration("dataSourceConfiguration")
@AutoConfigureOrder(1)
@DependsOn("springContextUtil")
public class DataSourceConfiguration {
    public static List<String> readDataSourceList = new ArrayList<>();
    Map<String,DataSource> readDataSourceMap = new HashMap<>();
    @Value("${datasource.type}")
    private Class<? extends DataSource> dataSourceType;
    private ConversionService conversionService = new DefaultConversionService();
    private PropertyValues dataSourcePropertyValues;
    private final static String dataSourceSplit = ",";

    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "datasource.write")
    public DataSource writeDataSource(@Qualifier("wallFilter")WallFilter wallFilter){
        log.info("----------------writeDataSource init -----------");
        DruidDataSource druidDataSource = (DruidDataSource) DataSourceBuilder.create().type(dataSourceType).build();
        List<Filter> filters = new ArrayList<>();
        filters.add(wallFilter);
        druidDataSource.setProxyFilters(filters);
        log.info("----------------writeDataSource init done-----------");
        return druidDataSource;
    }

    @Bean(name = "readDataSources")
    public Map<String,DataSource> readDataSources(Environment env){
        initCustomDataSources(env);
        return readDataSourceMap;
    }

    @Primary
    @Bean(name = "wallConfig")
    public WallConfig wallFilterConfig(){
        WallConfig wc = new WallConfig();
        wc.setMultiStatementAllow(true);
        return wc;
    }


    @Primary
    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    WallFilter wallFilter(@Qualifier("wallConfig")WallConfig wallConfig){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig);
        return wallFilter;
    }


    private void initCustomDataSources(Environment env){
        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env,"datasource.reads.");
        String readNames = propertyResolver.getProperty("names");
        for(String readName:readNames.split(dataSourceSplit)){
            Map<String,Object> dsMap = propertyResolver.getSubProperties(readName + ".");
            DataSource ds = buildDataSource(dsMap);
            if(ds != null){
                bindData(ds,env);
                readDataSourceMap.put(readName,ds);
                readDataSourceList.add(readName);
            }
        }
    }

    private void bindData(DataSource dataSource,Environment env){
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreInvalidFields(false);
        dataBinder.setIgnoreUnknownFields(true);
        if(dataSourcePropertyValues == null){
            Map<String, Object> rpr = new RelaxedPropertyResolver(env, "datasource.reads").getSubProperties(".");
            Map<String, Object> values = new HashMap<>(rpr);
            // 排除已经设置的属性
            values.remove("type");
            values.remove("driverClassName");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }

        dataBinder.bind(dataSourcePropertyValues);
    }

    public DataSource buildDataSource(Map<String,Object> dsMap){
        try{
            String driverClassName = dsMap.get(DataSourceConfig.DRIVER_CLASS_NAME).toString();
            String url = dsMap.get(DataSourceConfig.JDBC_URL).toString();
            String userName = dsMap.get(DataSourceConfig.USERNAME).toString();
            String password = dsMap.get(DataSourceConfig.PASSWORD).toString();
            DataSourceBuilder builder = DataSourceBuilder.create().driverClassName(driverClassName)
                    .url(url).password(password).username(userName);

            return builder.build();
        }catch (Exception e){
            log.info("build data source failed {}",e);
        }

        return null;
    }
}
