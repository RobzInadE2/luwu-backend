package com.luwu.model.liquibase;

import com.luwu.common.config.LuwuConfig;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import liquibase.Liquibase;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.apache.log4j.Logger;

import java.sql.Connection;

public abstract class LiquibaseBundleRunner implements ConfiguredBundle<LuwuConfig> {

    private static final Logger log = Logger.getLogger(LiquibaseBundleRunner.class);

    @Override
    public void run(LuwuConfig configuration, Environment environment) throws Exception {
        final DataSourceFactory dsFactory = createDataSourceFactory(configuration);
        final ManagedDataSource ds = dsFactory.build(environment.metrics(), "liquibase");

        try (Connection connection = ds.getConnection()) {
            log.info("Starting liquibase update");
            new Liquibase("liquibase.xml", new ClassLoaderResourceAccessor(), new JdbcConnection(connection)).update("");
            log.info("Liquibase update complete!");
        } finally {
            ds.stop();
        }
    }

    public abstract DataSourceFactory createDataSourceFactory(LuwuConfig luwuConfig);

    @Override
    public void initialize(Bootstrap<?> bootstrap) {
        //NOT USED
    }
}
