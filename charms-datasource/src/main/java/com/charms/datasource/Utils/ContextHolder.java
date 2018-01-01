package com.charms.datasource.Utils;

import com.charms.datasource.enums.DataSourceTypeEnum;

public class ContextHolder {
    /**
     * 读写类型
     */
    private static final ThreadLocal<DataSourceTypeEnum> localDataSource = new ThreadLocal<>();
    /**
     * 日志请求
     */
    private static final ThreadLocal<String> localRequest = new ThreadLocal<>();

    public ContextHolder() {
    }

    public static String getRequest(){
        return localRequest.get();
    }

    public static void setRequest(String request){
        localRequest.set(request);
    }

    public static void removeRequest(){
        localRequest.remove();
    }

    public static ThreadLocal<DataSourceTypeEnum> getLocalDataSource(){
        return localDataSource;
    }

    public static void writeDataSourceType(){
        localDataSource.set(DataSourceTypeEnum.WRITE);
    }

    public static void readDataSourceType(){
        localDataSource.set(DataSourceTypeEnum.READ);
    }

    public static void reportDataSourceType(){
        localDataSource.set(DataSourceTypeEnum.TIME_REPORT);
    }

    public static DataSourceTypeEnum getDataSourceType(){
        return localDataSource.get();
    }

    public static void removeDataSourceType(){
        localDataSource.remove();
    }

    public static void removeAll(){
        removeRequest();
        removeDataSourceType();
    }
}
