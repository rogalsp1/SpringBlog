package com.springblog.web;

import com.springblog.service.BlogPostService;
import com.springblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
