package com.luwu.web.config;

import com.google.inject.Injector;
import com.google.inject.Module;
import com.luwu.common.config.Registrator;
import com.luwu.web.api.UserResource;
import io.dropwizard.setup.Environment;

public class ResourceRegistrator implements Registrator {

    public void registerResources(Injector injector, Environment environment) {
        environment.jersey().register(injector.getInstance(UserResource.class));
    }

    @Override
    public Module injectorModule() {
        return binder -> {};
    }
}
