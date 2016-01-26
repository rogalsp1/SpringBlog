package com.springblog.web.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by rogalsp1 on 25.01.2016.
 */
@Data
public class NewCommentForm {

    @NotEmpty
    private String comment;
}
