package com.springblog.repository;

import com.springblog.domain.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rogalsp1 on 25.01.2016.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    @Query("select c from Comment c join fetch c.blogPost bp where bp.id = ?1")
    List<Comment> getCommentsForPost(Long postId);
}
