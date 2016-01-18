package com.springblog.repository;

import com.springblog.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by rogalsp1 on 15.01.2016.
 */

@Repository
public interface UserRepository  extends CrudRepository<User, Long>, UserRepositoryCustom{

    Optional<User> findUserByUsername(String username);
}
