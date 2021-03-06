package com.springblog.web.form;

import com.springblog.domain.enums.Role;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.xml.ws.RespectBinding;

/**
 * Created by rogalsp1 on 17.01.2016.
 */
@RespectBinding
@Data
public class NewUserForm {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String passwordRepeated;

    @NotNull
    private Role role = Role.USER;

}
