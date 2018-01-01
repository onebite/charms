package com.charms.datasource.config.readwrite;

import com.charms.datasource.Utils.ContextHolder;
import com.charms.datasource.enums.DataSourceTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class MyAbstractRoutingDataSource  extends AbstractRoutingDataSource{
    private final AtomicInteger count = new AtomicInteger(0);


    public MyAbstractRoutingDataSource() {
    }

    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceTypeEnum dataSourceType = ContextHolder.getDataSourceType();
        if(dataSourceType == null){
            log.debug("dataSourceType is null, current Service can't set a point cut");
            dataSourceType = DataSourceTypeEnum.WRITE;
        }
        if(dataSourceType == DataSourceTypeEnum.WRITE){
            log.debug("db type is {}",dataSourceType);
            return  dataSourceType;
        }

        int reads = DataSourceConfiguration.readDataSourceList.size();
        if(reads == 1){
            log.debug("db read is {}",DataSourceConfiguration.readDataSourceList.get(0));
            return DataSourceConfiguration.readDataSourceList.get(0);
        }

        if(dataSourceType == DataSourceTypeEnum.TIME_REPORT){
            log.debug("db report is {}",DataSourceConfiguration.readDataSourceList.get(reads - 1));
            return DataSourceConfiguration.readDataSourceList.get(reads-1);
        }

        int num = count.getAndAdd(1);
        int lookupKey = reads-1 > 0 ?  num %(reads -1) : 0;
        String dbKey = DataSourceConfiguration.readDataSourceList.get(lookupKey);
        log.info("db key is {}",dbKey);

        return dbKey;
    }
}
