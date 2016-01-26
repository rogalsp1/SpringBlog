package com.springblog.service;

import com.google.common.collect.Lists;
import com.springblog.domain.entity.BlogPost;
import com.springblog.domain.entity.Comment;
import com.springblog.repository.BlogPostRepository;
import com.springblog.repository.CommentRepository;
import com.springblog.repository.UserRepository;
import com.springblog.utils.DateUtils;
import com.springblog.web.form.NewCommentForm;
import com.springblog.web.form.NewPostForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserService userService;
    private final CommentRepository commentRepository;

    @Autowired
    public BlogPostServiceImpl(BlogPostRepository blogPostRepository, UserRepository userRepository, UserService userService, CommentRepository commentRepository) {
        this.blogPostRepository = blogPostRepository;
        this.userService = userService;
        this.commentRepository = commentRepository;
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

    private void setPostPicture(BlogPost blogPost, NewPostForm form){
        if(Objects.nonNull(form.getPostPicture())) {
            form.getPostPicture().setBlogPost(blogPost);
            blogPost.setPostPicture(form.getPostPicture());
            logger.info("Setting picture=[" + form.getPostPicture().getFilename() + "]");
        }
    }

    public BlogPost addComment(NewCommentForm commentForm, Long postId){
        BlogPost post = blogPostRepository.findOne(postId);
        Comment newComment = from(commentForm,post);
        post.getCommentList().add(newComment);
        return blogPostRepository.save(post);
    }

    private BlogPost from(NewPostForm postForm){
        BlogPost newBlogPost = new BlogPost();
        newBlogPost.setTitle(postForm.getTitle());
        newBlogPost.setPost(postForm.getPost());
        newBlogPost.setWhenPostCreated(DateUtils.now());
        newBlogPost.setAuthor(userService.getLoggedUser());
        setPostPicture(newBlogPost,postForm);
        return newBlogPost;
    }

    private Comment from(NewCommentForm form, BlogPost post){
        Comment newComment = new Comment();
        newComment.setComment(form.getComment());
        newComment.setAuthor(userService.getLoggedUser());
        newComment.setWhenCommentCreated(DateUtils.now());
        newComment.setBlogPost(post);
        return newComment;
    }
}

