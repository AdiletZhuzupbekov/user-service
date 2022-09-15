package kg.megacom.userservice.controller;

import kg.megacom.userservice.models.dto.UserDto;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.response.UserStatusResponse;
import kg.megacom.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //пункт №1
    @PostMapping("/photo")
    public UserDto addPhoto(@RequestPart MultipartFile file){
        return userService.addPhoto(file);
    }
    //пункт №2
    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }
    //пункт №3
    @GetMapping("/info")
    public UserDto getUserInfo(@RequestParam Long userId){
        return userService.findUserById(userId);
    }
    //пункт №4
    @PostMapping("/status")
    public UserStatusResponse changeStatus(@RequestParam Long userId, @RequestParam UserStatus userStatus){
        return userService.changeStatus(userId, userStatus);
    }
}
