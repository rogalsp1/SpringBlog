package com.springblog.domain.validators;


import com.springblog.service.UserService;
import com.springblog.web.form.NewUserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by rogalsp1 on 17.01.2016.
 */
@Component
public class RegistrationFormValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationFormValidator.class);

    private final UserService userService;

    @Autowired
    public RegistrationFormValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(NewUserForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        NewUserForm newUserForm = (NewUserForm) o;
        logger.info(newUserForm.getPassword() + " " +newUserForm.getPasswordRepeated());
        validatePassword(errors, newUserForm);
        validateUsername(errors, newUserForm);
    }

    public void validatePassword(Errors errors, NewUserForm newUserForm){
        if(!newUserForm.getPassword().equals(newUserForm.getPasswordRepeated()))
            errors.reject("password.no_match", "Passwords do not match");
    }

    public void validateUsername(Errors errors, NewUserForm newUserForm){
        if(userService.findUserByUsername(newUserForm.getUsername()).isPresent())
            errors.reject("username.exists", "Username already exists");
    }
}
