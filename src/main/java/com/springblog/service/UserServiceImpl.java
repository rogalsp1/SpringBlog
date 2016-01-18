package com.springblog.service;

import com.springblog.domain.entity.User;
import com.springblog.repository.UserRepository;
import com.springblog.web.form.NewUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User save(User user) {
        logger.info("Saving user= " + user.getUsername() +" email= " + user.getEmail());
        return userRepository.save(user);
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public List<User> findAll() {
        return null;
    }

    public Long count() {
        return null;
    }

    public void delete(User user) {
    }

    public Optional<User> findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User create(NewUserForm form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setEmail(form.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setRole(form.getRole());
        return userRepository.save(user);
    }


}
