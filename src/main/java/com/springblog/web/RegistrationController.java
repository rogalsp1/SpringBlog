package com.springblog.web;

import com.springblog.service.UserService;
import com.springblog.web.form.NewUserForm;
import com.springblog.domain.validators.RegistrationFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by rogalsp1 on 17.01.2016.
 */
@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    private final UserService userService;
    private final RegistrationFormValidator registrationFormValidator;

    @Autowired
    public RegistrationController(UserService userService, RegistrationFormValidator registrationFormValidator) {
        this.userService = userService;
        this.registrationFormValidator = registrationFormValidator;
    }

    @InitBinder("registrationForm")
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators();
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView getRegistrationPage(){
        return new ModelAndView("registration", "form", new NewUserForm());
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String handleRegistrationForm(@Valid @ModelAttribute("form") NewUserForm form, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return "registration";
        try{
            userService.create(form);
        } catch (DataIntegrityViolationException e ){
            bindingResult.reject("username.exists", "Username already exists");
            return "registration";
        }
        return "redirect:/login";
    }
}
