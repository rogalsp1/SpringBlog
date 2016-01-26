package com.springblog.service;

import com.springblog.domain.entity.Comment;

import java.util.List;

/**
 * Created by rogalsp1 on 26.01.2016.
 */
public interface CommentService {

    List<Comment> getCommentsForPost(Long postId);
}
