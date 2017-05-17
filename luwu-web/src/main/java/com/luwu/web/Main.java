package com.luwu.web;


import com.google.inject.Guice;
import com.google.inject.Injector;
import com.luwu.common.config.LuwuConfig;
import com.luwu.model.config.ModelRegistrator;
import com.luwu.web.config.ResourceRegistrator;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Main extends Application<LuwuConfig> {
    public static final String APP_NAME = "luwu-backend";

    private final ModelRegistrator modelRegistrator = new ModelRegistrator();
    private final ResourceRegistrator resourceRegistrator = new ResourceRegistrator();

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(LuwuConfig luwuConfig, Environment environment) throws Exception {
        final Injector injector = Guice.createInjector(
                modelRegistrator.injectorModule(),
                resourceRegistrator.injectorModule()
        );
        resourceRegistrator.registerResources(injector, environment);
    }

    @Override
    public void initialize(Bootstrap<LuwuConfig> bootstrap) {
        modelRegistrator.initialize(bootstrap);
    }

    @Override
    public String getName() {
        return APP_NAME;
    }
}
