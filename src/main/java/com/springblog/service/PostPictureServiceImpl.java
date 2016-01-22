package com.springblog.service;

import com.springblog.domain.entity.PostPicture;
import com.springblog.repository.PostPictureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
@Service
public class PostPictureServiceImpl implements PostPictureService {

    private static final Logger logger = LoggerFactory.getLogger(PostPictureServiceImpl.class);

    private final PostPictureRepository postPictureRepository;

    @Autowired
    public PostPictureServiceImpl(PostPictureRepository postPictureRepository) {
        this.postPictureRepository = postPictureRepository;
    }

    public PostPicture getPictureForPost(Long postId){
        return postPictureRepository.getPictureForPost(postId).orElse(new PostPicture());
    }

    @Override
    public PostPicture createPictureFromUploadedFile(MultipartFile multipartFile) throws IOException {
        PostPicture postPicture = new PostPicture();
        postPicture.setFilename(multipartFile.getOriginalFilename());
        postPicture.setImage(multipartFile.getBytes());
        return postPicture;
    }
}
