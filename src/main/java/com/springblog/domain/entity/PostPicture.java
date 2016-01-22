package com.springblog.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
@Entity
@Table(name = "POST_PICTURE")
@Data
@EqualsAndHashCode(exclude = {"id","blogPost"})
public class PostPicture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String filename;

    @Column(name = "IMAGE_FILE")
    private byte[] image;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private BlogPost blogPost;

}
