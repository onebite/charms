package com.charms.user.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

import java.util.concurrent.atomic.AtomicInteger;

public class RobinRoutingDataSource extends AbstractRoutingDataSource {
    private AtomicInteger count = new AtomicInteger(0);

    public RobinRoutingDataSource() {
    }

    @Nullable
    protected Object determineCurrentLookupKey() {

        return null;
    }
}
