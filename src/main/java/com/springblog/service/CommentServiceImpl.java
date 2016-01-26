package com.springblog.service;

import com.springblog.domain.entity.Comment;
import com.springblog.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rogalsp1 on 26.01.2016.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsForPost(Long postId) {
        return commentRepository.getCommentsForPost(postId);
    }
}
