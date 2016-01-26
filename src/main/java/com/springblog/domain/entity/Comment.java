package com.springblog.domain.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by rogalsp1 on 25.01.2016.
 */
@Data
@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;

    @Column(name = "WHEN_COMMENT_CREATED")
    private Timestamp whenCommentCreated;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private BlogPost blogPost;

}
