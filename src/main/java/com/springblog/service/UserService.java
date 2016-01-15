package com.springblog.service;

import com.springblog.domain.User;
import com.springblog.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rogalsp1 on 15.01.2016.
 */

public interface UserService{

    User save(User user);

    User findOne(Long id);

    List<User> findAll();

    Long count();

    void delete(User user);
}
