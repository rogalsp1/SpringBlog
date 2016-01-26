package com.springblog.web;

import com.springblog.domain.entity.BlogPost;
import com.springblog.domain.entity.Comment;
import com.springblog.service.BlogPostService;
import com.springblog.service.CommentService;
import com.springblog.service.UserService;
import com.springblog.web.form.NewCommentForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private final CommentService commentService;

    @Autowired
    public IndexController(BlogPostService blogPostService, UserService userService, CommentService commentService) {
        this.blogPostService = blogPostService;
        this.userService = userService;
        this.commentService = commentService;
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

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public ModelAndView postPage(@PathVariable final Long id, ModelAndView modelAndView){
        createModelForPost(id,modelAndView);
        return modelAndView;
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.POST)
    public String addComment(@ModelAttribute(value = "commentForm") NewCommentForm form, @PathVariable Long id){
        blogPostService.addComment(form,id);
        return "redirect:/post/" + id;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

    private void createModelForPost(Long id, ModelAndView modelAndView){
        BlogPost post = blogPostService.findOne(id);
        List<Comment> commentList = commentService.getCommentsForPost(id);
        NewCommentForm form = new NewCommentForm();
        modelAndView.addObject("post", post);
        modelAndView.addObject("commentForm", form);
        modelAndView.addObject("commentList", commentList);
        modelAndView.setViewName("post");
    }
}
