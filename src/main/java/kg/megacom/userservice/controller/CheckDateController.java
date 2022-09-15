package kg.megacom.userservice.controller;

import kg.megacom.userservice.models.User;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.response.CheckDateResponse;
import kg.megacom.userservice.service.DateRequestService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/user-status")
public class CheckDateController {
    private  final DateRequestService dateRequestService;

    public CheckDateController(DateRequestService dateRequestService) {
        this.dateRequestService = dateRequestService;
    }

    //пункт №5
    @GetMapping("/check")
    public List<CheckDateResponse> getUsersByStatus(
            @RequestParam(required = false) UserStatus userStatus,
            @DateTimeFormat(pattern =  "yyyy-MM-dd'T'HH:mm:ss") @RequestParam(required = false) Date date){
        return dateRequestService.getUsersByStatus(userStatus,date);
    }
}
