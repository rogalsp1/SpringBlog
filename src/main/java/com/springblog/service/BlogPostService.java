package com.springblog.service;

import com.springblog.domain.entity.BlogPost;

import java.util.List;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
public interface BlogPostService{

    BlogPost save(BlogPost blogPost);

    BlogPost findOne(Long id);

    List<BlogPost> findAll();

    Long count();

    void delete(BlogPost blogPost);
}
