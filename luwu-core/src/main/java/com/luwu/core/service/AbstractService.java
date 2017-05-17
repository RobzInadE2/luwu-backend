package com.luwu.core.service;

import io.dropwizard.hibernate.AbstractDAO;

abstract class AbstractService<T extends AbstractDAO> {

    protected final T dao;

    protected AbstractService(T dao) {
        this.dao = dao;
    }

    public T getDao() {
        return dao;
    }
}
