package com.springblog.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 13.01.2016.
 */

@Entity
@Table(name = "BLOG_POST")
@Data
@EqualsAndHashCode(exclude = {"id","postPicture"})
public class BlogPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String post;

    private Timestamp whenPostCreated;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User author;

    @Nullable
    @OneToOne(mappedBy = "blogPost", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PostPicture postPicture;


}
