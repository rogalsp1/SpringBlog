package com.springblog.repository;

import com.springblog.domain.entity.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rogalsp1 on 15.01.2016.
 */
@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
}
