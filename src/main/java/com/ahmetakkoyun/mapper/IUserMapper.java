package com.ahmetakkoyun.mapper;

import com.ahmetakkoyun.dto.request.RegisterRequestDto;
import com.ahmetakkoyun.dto.response.UserResponseDto;
import com.ahmetakkoyun.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)  // eşleşmeyenleri ignore et. hata fırlatma. null getir.
public interface IUserMapper {
    // mapper daha kolay mapleme yapmak için. hızlanmak için. zorunlu değil.

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    UserResponseDto toUserResponseDto(User user); // artık User ile UserResponseDto bilgileri otomatik maplenecek

    User toUser(RegisterRequestDto dto);

    List<UserResponseDto> toUserResponseDtos(List<User> userList);


}
