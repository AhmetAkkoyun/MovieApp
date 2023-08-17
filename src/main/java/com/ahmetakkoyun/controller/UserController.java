package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


//    http://localhost:8090/user/save?name=Ahmet&surname=Akkoyun&email=ahmet@ahmet&phone=123456&password=123
    @GetMapping("/save")
    public User createUser(String name, String surname, String email, String password, String phone){
        User user = User.builder()
                .name(name)
                .surName(surname)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
        return  userService.createUser(user);
    }

}
