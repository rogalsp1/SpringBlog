package com.springblog.service;

import com.springblog.domain.entity.User;
import com.springblog.web.form.NewUserForm;

import java.util.List;
import java.util.Optional;

/**
 * Created by rogalsp1 on 15.01.2016.
 */

public interface UserService{

    User save(User user);

    User findOne(Long id);

    List<User> findAll();

    Long count();

    void delete(User user);

    Optional<User> findUserByUsername(String username);

    User create(NewUserForm form);
}
