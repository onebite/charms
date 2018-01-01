package com.charms.datasource.config.readwrite;

import com.charms.datasource.Utils.ContextHolder;
import com.charms.datasource.annotation.DataSourceType;
import com.charms.datasource.constants.BusinessConstants;
import com.charms.datasource.enums.DataSourceTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
@Order(1)
public class DataSourceAop {

    @Around("execution(* com.charms..*.service..*.*(..)))")
    public Object setDataSourceType(ProceedingJoinPoint joinPoint) throws Throwable{
        DataSourceTypeEnum typeEnum = ContextHolder.getDataSourceType();
        try{
            setDataSource(joinPoint);
        }catch (Throwable t){

        }

        Object result = joinPoint.proceed();
        setType(typeEnum);
        return result;
    }

    private void setDataSource(ProceedingJoinPoint joinPoint){
        Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
        DataSourceType dataSourceType = method.getAnnotation(DataSourceType.class);
        if(dataSourceType != null){
            setType(dataSourceType.type());
            return ;
        }
        //若没有注解，以方法名切换
        String methodName = method.getName();
        if(methodName.matches(BusinessConstants.READ_METHOD)){
            read();
        }else{
            write();
        }
    }


    private void setType(DataSourceTypeEnum type){
        switch (type){
            case READ:
                read();
                break;
            case WRITE:
                write();
                break;
            case TIME_REPORT:
                report();
                break;
            default:
                write();
                break;
        }
    }


    public void write(){
        ContextHolder.writeDataSourceType();
        log.debug("DataSourceAop : datasource transform to write base");
    }

    public void read(){
        ContextHolder.readDataSourceType();
        log.debug("DataSourceAop : datasource transform to read base");
    }

    public void report(){
        ContextHolder.reportDataSourceType();
        log.debug("DataSourceAop : datasource transform to report base");
    }

}
