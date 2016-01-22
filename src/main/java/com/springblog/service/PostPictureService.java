package com.springblog.service;

import com.springblog.domain.entity.PostPicture;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
public interface PostPictureService {

    PostPicture getPictureForPost(Long postId);

    PostPicture createPictureFromUploadedFile(MultipartFile multipartFile) throws IOException;
}
