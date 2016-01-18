package com.springblog.domain.dto;

import com.springblog.domain.entity.User;
import com.springblog.domain.enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

/**
 * Created by rogalsp1 on 16.01.2016.
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public CurrentUser(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser(){
        return user;
    }

    public Long getId(){
        return  user.getId();
    }

    public Role getRole(){
        return user.getRole();
    }
}
