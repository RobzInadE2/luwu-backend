package com.luwu.common.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

public class LuwuConfig extends Configuration {

    @JsonProperty
    private DbConfig dbConfig = new DbConfig();

    public DbConfig getDbConfig() {
        return dbConfig;
    }

    public void setDbConfig(DbConfig dbConfig) {
        this.dbConfig = dbConfig;
    }
}
