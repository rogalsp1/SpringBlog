package com.springblog.web.form;

import com.springblog.domain.entity.PostPicture;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Created by rogalsp1 on 21.01.2016.
 */
@Data
public class NewPostForm {

    @NotEmpty
    private String title;

    @NotEmpty
    private String post;

    private PostPicture postPicture;
}
