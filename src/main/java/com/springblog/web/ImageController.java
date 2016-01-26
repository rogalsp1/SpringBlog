package com.springblog.web;

import com.springblog.domain.entity.PostPicture;
import com.springblog.service.PostPictureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by rogalsp1 on 25.01.2016.
 */
@Controller
public class ImageController {

    private static final Logger logger = LoggerFactory.getLogger(ImageController.class);

    private final PostPictureService postPictureService;

    @Autowired
    public ImageController(PostPictureService postPictureService) {
        this.postPictureService = postPictureService;
    }

    @RequestMapping(value = "/image/{postId}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImageForPost(@PathVariable final String postId){
        logger.info("Getting image for post [postId= " + postId + "]");
        byte[] image = postPictureService.getPictureForPost(Long.parseLong(postId)).getImage();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<byte[]>(image, headers, HttpStatus.CREATED);
    }
}
