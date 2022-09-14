package kg.megacom.userservice.service;

import kg.megacom.userservice.models.dto.UserDto;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.response.UserStatusResponse;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto findUserById(Long userId);

    UserStatusResponse changeStatus(Long userId, UserStatus userStatus);

    UserDto addPhoto(MultipartFile file);
}
