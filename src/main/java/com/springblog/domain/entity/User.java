package com.springblog.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.CheckForNull;
import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 13.01.2016.
 */

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    private Boolean admin;

    @Column(name = "ACTIVATION_DATE")
    private Timestamp activationDate;
}
