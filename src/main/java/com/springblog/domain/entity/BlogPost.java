package com.springblog.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 13.01.2016.
 */

@Data
@Entity
@Table(name = "BLOG_POST")
public class BlogPost {

    @Id
    private Long id;

    private String title;

    private String post;

    private LocalDateTime whenPostCreated;
}
