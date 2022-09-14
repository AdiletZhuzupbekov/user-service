package kg.megacom.userservice.service;

import kg.megacom.userservice.models.User;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.response.CheckDateResponse;

import java.util.Date;
import java.util.List;

public interface DateRequestService {
    List<CheckDateResponse> getUsersByStatus(UserStatus userStatus, Date date);
}
