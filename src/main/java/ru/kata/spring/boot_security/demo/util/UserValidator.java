package ru.kata.spring.boot_security.demo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

@Component
public class UserValidator implements Validator {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserValidator(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
User user = (User) target;
if(userServiceImpl.findByEmail(user.getUsername()).isPresent()){
    errors.rejectValue("email","","email уже используется");
}
    }
}
