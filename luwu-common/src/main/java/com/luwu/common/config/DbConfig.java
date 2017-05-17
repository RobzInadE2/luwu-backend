package com.luwu.common.config;

import io.dropwizard.util.Duration;
import io.dropwizard.validation.MinDuration;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DbConfig {

    private String driverClass;
    private String user;
    private String password;
    private String url;

    private Map<String, String> properties;

    private String validationQuery;

    @MinDuration(value = 1)
    private Duration maxWaitForConnection = Duration.seconds(1);
    @MinDuration(value = 1)
    private Duration validationQueryTimeout = Duration.seconds(3);
    @MinDuration(value = 1)
    private Duration evictionInterval = Duration.seconds(10);
    @MinDuration(value = 1, unit = TimeUnit.MINUTES)
    private Duration minIdleTime = Duration.minutes(1);

    private int minSize;
    private int maxSize;
    private boolean checkConnectionWhileIdle;

    public String getDriverClass() {
        return driverClass;
    }

    public void setDriverClass(String driverClass) {
        this.driverClass = driverClass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public String getValidationQuery() {
        return validationQuery;
    }

    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }

    public Duration getMaxWaitForConnection() {
        return maxWaitForConnection;
    }

    public void setMaxWaitForConnection(Duration maxWaitForConnection) {
        this.maxWaitForConnection = maxWaitForConnection;
    }

    public Duration getValidationQueryTimeout() {
        return validationQueryTimeout;
    }

    public void setValidationQueryTimeout(Duration validationQueryTimeout) {
        this.validationQueryTimeout = validationQueryTimeout;
    }

    public Duration getEvictionInterval() {
        return evictionInterval;
    }

    public void setEvictionInterval(Duration evictionInterval) {
        this.evictionInterval = evictionInterval;
    }

    public Duration getMinIdleTime() {
        return minIdleTime;
    }

    public void setMinIdleTime(Duration minIdleTime) {
        this.minIdleTime = minIdleTime;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isCheckConnectionWhileIdle() {
        return checkConnectionWhileIdle;
    }

    public void setCheckConnectionWhileIdle(boolean checkConnectionWhileIdle) {
        this.checkConnectionWhileIdle = checkConnectionWhileIdle;
    }
}
