package com.ahmetakkoyun.sevice;

import com.ahmetakkoyun.dto.request.LoginRequestDto;
import com.ahmetakkoyun.dto.request.RegisterRequestDto;
import com.ahmetakkoyun.dto.response.UserResponseDto;
import com.ahmetakkoyun.mapper.IUserMapper;
import com.ahmetakkoyun.repository.IUserRepository;
import com.ahmetakkoyun.repository.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final IUserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User register(RegisterRequestDto dto) {
//        User user= User.builder()
//                .name(dto.getName())
//                .surName(dto.getSurName())
//                .email(dto.getEmail())
//                .password(dto.getPassword())
//                .phone(dto.getPhone())
//                .build();
        User user = IUserMapper.INSTANCE.toUser(dto);
        return userRepository.save(user);
    }


    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı bulunamadı!!!");
        }
          return user.get();
    }

    public UserResponseDto login(LoginRequestDto dto) {
        Optional<User> user = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (user.isEmpty()){
            throw new RuntimeException("Kullanıcı bulunamadı!!!");
        }
//        UserResponseDto userResponseDto = new UserResponseDto().builder()
//                .id(user.get().getId())
//                .name(user.get().getName())
//                .surName(user.get().getSurName())
//                .email(user.get().getEmail())
//                .phone(user.get().getPhone())
//                .userType(user.get().getUserType())
//                .build();

//        UserResponseDto userResponseDto = IUserMapper.INSTANCE.toUserResponseDto(user.get());  // mapper sayesinde yukardaki builder kısmının kısa hali.

        return IUserMapper.INSTANCE.toUserResponseDto(user.get());
    }

    public List<User> findAllByOrderByName(){
        return userRepository.findAllByOrderByName();
    }

    public List<User> findAllByOrderByNameDesc(){
        return userRepository.findAllByOrderByNameDesc();
    }

    public List<UserResponseDto> findAllByNameContainingIgnoreCase(String value){
        List<User> userList = userRepository.findAllByNameContainingIgnoreCase(value);
        if (userList.isEmpty()){                                                // araya böyle bir denetim ekleyelim.
            throw new RuntimeException("Herhangi bir veri bulunamadı!!!");
        }
//        List<UserResponseDto> list = userList.stream().map(x->IUserMapper.INSTANCE.toUserResponseDto(x)).collect(Collectors.toList());  // verilerin hepsi eşleşmeseydi böyle yapacaktık
        return IUserMapper.INSTANCE.toUserResponseDtos(userList);
    }

    public List<User> findAllByEmailContainingIgnoreCase(String value){
        return userRepository.findAllByEmailContainingIgnoreCase(value);
    }

    public List<User> findAllByEmailEndingWith(String value){
        return userRepository.findAllByEmailEndingWith(value);
    }

    public List<User> paswordLongerThan(int value){
        return userRepository.paswordLongerThan(value);
    }

    public List<User> paswordLongerThan2(int value){
        return userRepository.paswordLongerThan2(value);
    }

    public List<User> paswordLongerThan3(int value){
        return userRepository.paswordLongerThan2(value);
    }

}
