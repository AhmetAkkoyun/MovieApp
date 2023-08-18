package com.ahmetakkoyun.sevice;

import com.ahmetakkoyun.dto.request.LoginRequestDto;
import com.ahmetakkoyun.dto.request.RegisterRequestDto;
import com.ahmetakkoyun.repository.IUserRepository;
import com.ahmetakkoyun.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User register(RegisterRequestDto dto) {
        User user= User.builder()
                .name(dto.getName())
                .surName(dto.getSurName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .phone(dto.getPhone())
                .build();
        return userRepository.save(user);
    }


    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı bulunamadı!!!");
        }
          return user.get();
    }

    public User login(LoginRequestDto dto) {
        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı bulunamadı!!!");
        }

        return user.get();

    }
}
