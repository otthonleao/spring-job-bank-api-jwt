package dev.otthon.jobbank.api.auth.mappers;

import dev.otthon.jobbank.api.auth.dtos.UserRequestDTO;
import dev.otthon.jobbank.api.auth.dtos.UserResponseDTO;
import dev.otthon.jobbank.core.models.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ModelMapperUserMapper implements UserMapper {

    private final ModelMapper modelMapper;

    @Override
    public UserResponseDTO toUserResponseDTO(User user) {
        return modelMapper.map(user, UserResponseDTO.class);
    }

    @Override
    public User toUser(UserRequestDTO userRequestDTO) {
        return modelMapper.map(userRequestDTO, User.class);
    }
}
