package com.luwu.model.config;

import com.google.inject.Module;
import com.luwu.common.config.DbConfig;
import com.luwu.common.config.LuwuConfig;
import com.luwu.common.config.Registrator;
import com.luwu.model.liquibase.LiquibaseBundleRunner;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.ScanningHibernateBundle;
import io.dropwizard.setup.Bootstrap;
import org.hibernate.SessionFactory;

public class ModelRegistrator implements Registrator {

    private final HibernateBundle<LuwuConfig> hibernate = new ScanningHibernateBundle<LuwuConfig>("com.luwu.model.entity") {
        @Override
        public PooledDataSourceFactory getDataSourceFactory(LuwuConfig configuration) {
            return dbConfig(configuration);
        }
    };

    public void initialize(Bootstrap<LuwuConfig> bootstrap) {
        bootstrap.addBundle(new LiquibaseBundleRunner() {
            @Override
            public DataSourceFactory createDataSourceFactory(LuwuConfig luwuConfig) {
                return dbConfig(luwuConfig);
            }
        });
        bootstrap.addBundle(hibernate);
    }

    @Override
    public Module injectorModule() {
        return binder -> binder.bind(SessionFactory.class).toInstance(hibernate.getSessionFactory());
    }

    private DataSourceFactory dbConfig(LuwuConfig luwuConfig) {
        final DbConfig dbConfig = luwuConfig.getDbConfig();
        final DataSourceFactory dataSourceFactory = new DataSourceFactory();
        dataSourceFactory.setDriverClass(dbConfig.getDriverClass());
        dataSourceFactory.setUser(dbConfig.getUser());
        dataSourceFactory.setPassword(dbConfig.getPassword());
        dataSourceFactory.setUrl(dbConfig.getUrl());
        dataSourceFactory.setProperties(dbConfig.getProperties());
        dataSourceFactory.setMaxWaitForConnection(dbConfig.getMaxWaitForConnection());
        dataSourceFactory.setValidationQuery(dbConfig.getValidationQuery());
        dataSourceFactory.setValidationQueryTimeout(dbConfig.getValidationQueryTimeout());
        dataSourceFactory.setMinSize(dbConfig.getMinSize());
        dataSourceFactory.setMaxSize(dbConfig.getMaxSize());
        dataSourceFactory.setCheckConnectionWhileIdle(dbConfig.isCheckConnectionWhileIdle());
        dataSourceFactory.setMinIdleTime(dbConfig.getMinIdleTime());
        return dataSourceFactory;
    }
}
