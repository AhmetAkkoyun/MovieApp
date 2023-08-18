package com.ahmetakkoyun.controller;

import com.ahmetakkoyun.dto.request.LoginRequestDto;
import com.ahmetakkoyun.dto.request.RegisterRequestDto;
import com.ahmetakkoyun.repository.entity.User;
import com.ahmetakkoyun.sevice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.ahmetakkoyun.constant.RestApiUrl.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


//    http://localhost:8090/user/save?name=Ahmet&surname=Akkoyun&email=ahmet@ahmet&phone=123456&password=123
    @GetMapping("/save")
    public ResponseEntity<?> createUser(String name, String surname, String email, String password, String phone){
        User user = User.builder()
                .name(name)
                .surName(surname)
                .email(email)
                .password(password)
                .phone(phone)
                .build();
        try {
            userService.createUser(user);
            return ResponseEntity.ok(user);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Kullanıcı oluşturulamadı");
        }
    }

    @GetMapping(REGISTER)
    public ResponseEntity<User> register (RegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }

    @PostMapping(REGISTER)
    public ResponseEntity<User> register2 (@RequestBody RegisterRequestDto dto){
        return ResponseEntity.ok(userService.register(dto));
    }


    @GetMapping(FINDBYID+"/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping(FINDBYID)
    public ResponseEntity<User> findById2(@RequestParam(required = false, defaultValue = "1") Long id){
        if (id == null){
            throw new RuntimeException("id null");
        }
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping(LOGIN)
    public ResponseEntity<User> login(@RequestBody LoginRequestDto dto){
        return ResponseEntity.ok(userService.login(dto));
    }

}
