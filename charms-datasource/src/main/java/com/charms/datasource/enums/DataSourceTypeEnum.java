package com.charms.datasource.enums;

public enum DataSourceTypeEnum {
    WRITE("写库"),
    READ("读库"),
    TIME_REPORT("计时库");

    private String description;

    DataSourceTypeEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
