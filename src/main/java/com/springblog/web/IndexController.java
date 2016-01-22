package com.springblog.web;

import com.springblog.domain.entity.BlogPost;
import com.springblog.domain.entity.User;
import com.springblog.domain.enums.Role;
import com.springblog.service.BlogPostService;
import com.springblog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by rogalsp1 on 15.01.2016.
 */

@Controller
public class IndexController {

    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    private final BlogPostService blogPostService;
    private final UserService userService;

    @Autowired
    public IndexController(BlogPostService blogPostService, UserService userService) {
        this.blogPostService = blogPostService;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index(){
        List<BlogPost> postList = blogPostService.findAll();
        return new ModelAndView("index","postList",postList);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam Optional<String> error){
        return new ModelAndView("login", "error", error);
    }
}
