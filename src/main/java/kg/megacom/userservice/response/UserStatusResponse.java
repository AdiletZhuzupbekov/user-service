package kg.megacom.userservice.response;

import kg.megacom.userservice.models.enums.UserStatus;
import lombok.Data;

@Data
public class UserStatusResponse {
    private Long userId;
    private UserStatus newStatus;
    private UserStatus oldStatus;
}
