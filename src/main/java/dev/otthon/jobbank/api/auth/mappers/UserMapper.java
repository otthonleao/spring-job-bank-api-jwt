package dev.otthon.jobbank.api.auth.mappers;

import dev.otthon.jobbank.api.auth.dtos.UserRequestDTO;
import dev.otthon.jobbank.api.auth.dtos.UserResponseDTO;
import dev.otthon.jobbank.core.models.User;

public interface UserMapper {

    UserResponseDTO toUserResponseDTO(User user);
    User toUser(UserRequestDTO userRequestDTO);

}
