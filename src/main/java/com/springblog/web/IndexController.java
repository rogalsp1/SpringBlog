package com.springblog.web;

import com.springblog.domain.BlogPost;
import com.springblog.domain.User;
import com.springblog.repository.UserRepository;
import com.springblog.service.BlogPostService;
import com.springblog.service.UserService;
import com.springblog.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Created by rogalsp1 on 15.01.2016.
 */

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private UserService userService;


    @RequestMapping("/")
    String index(){
        return "index";
    }
}
