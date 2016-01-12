package com.springblog.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 13.01.2016.
 */

@Data
@Entity
public class BlogPost {

    private Long id;

    private String title;

    private String post;

    private LocalDateTime whenPostCreated;
}
