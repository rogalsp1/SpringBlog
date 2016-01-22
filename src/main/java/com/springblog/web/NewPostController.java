package com.springblog.web;

import com.springblog.domain.entity.PostPicture;
import com.springblog.service.BlogPostService;
import com.springblog.service.PostPictureService;
import com.springblog.web.form.NewPostForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.Objects;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
@Controller
public class NewPostController {

    private static final Logger logger = LoggerFactory.getLogger(NewPostController.class);

    private final BlogPostService blogPostService;
    private final PostPictureService postPictureService;

    private PostPicture postPicture;

    @Autowired
    public NewPostController(BlogPostService blogPostService, PostPictureService postPictureService) {
        this.blogPostService = blogPostService;
        this.postPictureService = postPictureService;
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.GET)
    public ModelAndView newPost() {
        NewPostForm form = new NewPostForm();
        return new ModelAndView("newPost", "newPostForm", form);
    }

    @RequestMapping(value = "/newPost", method = RequestMethod.POST)
    public String handleNewPostForm(@ModelAttribute(value = "newPostForm")NewPostForm form, BindingResult bindingResult) throws IOException {
        if(bindingResult.hasErrors())
            return "/newPost?error";
        if(Objects.nonNull(postPicture))
            form.setPostPicture(postPicture);
        blogPostService.create(form);
        return "redirect:/";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {
        try {
            postPicture = postPictureService.createPictureFromUploadedFile(uploadfile);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
