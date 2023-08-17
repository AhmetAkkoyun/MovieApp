package com.ahmetakkoyun.sevice;

import com.ahmetakkoyun.repository.IUserRepository;
import com.ahmetakkoyun.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}
