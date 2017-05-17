package com.luwu.core.service;

import com.luwu.core.dto.UserDto;
import com.luwu.model.dao.UserDao;
import com.luwu.model.entity.User;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public class UserService extends AbstractService<UserDao> {

    @Inject
    private UserService(UserDao userDao) {
        super(userDao);
    }

    public List<UserDto> findAll() {
        final List<User> allUsers = dao.findAll();
        return allUsers.stream().map(UserDto::fromDb).collect(Collectors.toList());
    }
}
