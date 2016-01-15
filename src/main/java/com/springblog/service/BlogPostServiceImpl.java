package com.springblog.service;

import com.google.common.collect.Lists;
import com.springblog.domain.BlogPost;
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

    private BlogPostRepository blogPostRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository) {
        this.blogPostRepository = blogPostRepository;
    }

    @Override
    public BlogPost save(BlogPost blogPost) {
        return blogPostRepository.save(blogPost);
    }


    @Override
    public BlogPost findOne(Long id) {
        return blogPostRepository.findOne(id) ;
    }

    @Override
    public List<BlogPost> findAll() {
        return Lists.newArrayList(blogPostRepository.findAll());
    }

    @Override
    public Long count() {
        return blogPostRepository.count();
    }

    @Override
    public void delete(BlogPost blogPost) {
        blogPostRepository.delete(blogPost);
    }
}

