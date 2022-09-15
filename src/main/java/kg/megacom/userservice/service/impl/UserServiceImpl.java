package kg.megacom.userservice.service.impl;

import kg.megacom.userservice.mappers.UserMapper;
import kg.megacom.userservice.microservices.FileServiceFeign;
import kg.megacom.userservice.microservices.json.UrlResponse;
import kg.megacom.userservice.models.User;
import kg.megacom.userservice.models.dto.UserDto;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.repository.UserRepo;
import kg.megacom.userservice.response.UserStatusResponse;
import kg.megacom.userservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final FileServiceFeign fileServiceFeign;

    public UserServiceImpl(UserRepo userRepo, FileServiceFeign fileServiceFeign) {
        this.userRepo = userRepo;
        this.fileServiceFeign = fileServiceFeign;
        this.userMapper = UserMapper.INSTANCE;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setUserStatus(UserStatus.ONLINE);
        user.setCheckDate(new Date());
        userRepo.save(user);
        UserDto uDto = new UserDto();
        uDto.setId(user.getId());
        return uDto;
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = userRepo.findById(userId).orElseThrow();
        UserDto userDto = userMapper.toDto(user);
        userDto.setId(null);
        return userDto;
    }

    @Override
    public UserStatusResponse changeStatus(Long userId, UserStatus userStatus) {
        UserStatusResponse userStatusResponse = new UserStatusResponse();
        User user = userRepo.findById(userId).orElseThrow();
        userStatusResponse.setOldStatus(user.getUserStatus());
        user.setUserStatus(userStatus);
        user.setCheckDate(new Date());
        userStatusResponse.setNewStatus(userStatus);
        userStatusResponse.setUserId(userId);
        userRepo.save(user);
        //иммитация задержки сервера
        try {
            Thread.sleep( 5000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        return userStatusResponse;
    }

    @Override
    public UserDto addPhoto(MultipartFile file) {
        UrlResponse urlResponse = fileServiceFeign.upload(file);
        UserDto userDto = new UserDto();
        userDto.setImgUrl(urlResponse.getFileUrl());
        return userDto;
    }
}
