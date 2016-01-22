package com.springblog.repository;

import com.springblog.domain.entity.PostPicture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
@Repository
public interface PostPictureRepository extends CrudRepository<PostPicture, Long> {

    @Query("select p from PostPicture p join fetch p.blogPost bp where bp.id = ?1")
    Optional<PostPicture> getPictureForPost(Long postId);
}
