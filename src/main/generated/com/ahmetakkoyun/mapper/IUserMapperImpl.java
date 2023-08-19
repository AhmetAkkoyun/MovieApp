package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.RegisterRequestDto;
import com.ahmetakkoyun.dto.response.UserResponseDto;
import com.ahmetakkoyun.repository.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-18T19:11:25+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 19.0.2 (Amazon.com Inc.)"
)
@Component
public class IUserMapperImpl implements IUserMapper {

    @Override
    public UserResponseDto toUserResponseDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResponseDto.UserResponseDtoBuilder userResponseDto = UserResponseDto.builder();

        userResponseDto.id( user.getId() );
        userResponseDto.name( user.getName() );
        userResponseDto.surName( user.getSurName() );
        userResponseDto.email( user.getEmail() );
        userResponseDto.phone( user.getPhone() );
        userResponseDto.userType( user.getUserType() );

        return userResponseDto.build();
    }

    @Override
    public User toUser(RegisterRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( dto.getName() );
        user.surName( dto.getSurName() );
        user.password( dto.getPassword() );
        user.email( dto.getEmail() );
        user.phone( dto.getPhone() );

        return user.build();
    }

    @Override
    public List<UserResponseDto> toUserResponseDtos(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserResponseDto> list = new ArrayList<UserResponseDto>( userList.size() );
        for ( User user : userList ) {
            list.add( toUserResponseDto( user ) );
        }

        return list;
    }
}
