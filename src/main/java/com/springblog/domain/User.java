package com.springblog.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 13.01.2016.
 */

@Data
@Entity
public class User {

    private Long id;

    private String username;

    private String password;

    private String email;

    private Boolean admin;

    private LocalDateTime activation;
}
