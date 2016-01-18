package com.springblog.service;

import com.google.common.collect.Lists;
import com.springblog.domain.entity.BlogPost;
import com.springblog.repository.BlogPostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger logger = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    private final BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }

    public BlogPost findOne(Long id) {
        return blogPostRepository.findOne(id) ;
    }

    public List<BlogPost> findAll() {
        return Lists.newArrayList(blogPostRepository.findAll());
    }

    public Long count() {
        return blogPostRepository.count();
    }

    public void delete(BlogPost blogPost) {
        blogPostRepository.delete(blogPost);
    }
}

