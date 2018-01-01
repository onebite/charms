package com.charms.datasource.annotation;

import com.charms.datasource.enums.DataSourceTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSourceType {
    DataSourceTypeEnum type() default DataSourceTypeEnum.WRITE;
}
