package com.springblog.service;

import com.google.common.collect.Lists;
import com.springblog.domain.entity.BlogPost;
import com.springblog.domain.entity.User;
import com.springblog.repository.BlogPostRepository;
import com.springblog.repository.UserRepository;
import com.springblog.utils.DateUtils;
import com.springblog.web.form.NewPostForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
@Service
public class BlogPostServiceImpl implements BlogPostService {

    private static final Logger logger = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    private final BlogPostRepository blogPostRepository;
    private final UserRepository userRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository, UserRepository userRepository) {
        this.blogPostRepository = blogPostRepository;
        this.userRepository = userRepository;
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

    public BlogPost create(NewPostForm postForm){
        BlogPost newBlogPost = from(postForm);
        return blogPostRepository.save(newBlogPost);
    }

    private User getLoggedUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findUserByUsername(username).orElse(userRepository.findOne(1l));
    }

    private BlogPost from(NewPostForm postForm){
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setTitle(postForm.getTitle());
        newBlogPost.setPost(postForm.getPost());
        newBlogPost.setWhenPostCreated(DateUtils.now());
        newBlogPost.setAuthor(getLoggedUser());
        setPostPicture(newBlogPost,postForm);
        return newBlogPost;
    }

    private void setPostPicture(BlogPost blogPost, NewPostForm form){
        if(Objects.nonNull(form.getPostPicture())) {
            form.getPostPicture().setBlogPost(blogPost);
            blogPost.setPostPicture(form.getPostPicture());
            logger.info("Setting picture=[" + form.getPostPicture().getFilename() + "]");
        }
    }
}

