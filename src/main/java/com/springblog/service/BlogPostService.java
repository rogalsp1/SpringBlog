package com.springblog.service;

import com.google.common.collect.Lists;
import com.springblog.domain.BlogPost;
import org.springframework.stereotype.Service;

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
