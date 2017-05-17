package com.luwu.model.dao;


import com.luwu.model.entity.User;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;

public class UserDao extends AbstractDAO<User> {

    @Inject
    private UserDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public List<User> findAll() {
        return list(query("SELECT u FROM User u"));
    }
}
