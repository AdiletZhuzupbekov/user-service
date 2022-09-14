package kg.megacom.userservice.response;

import kg.megacom.userservice.models.enums.UserStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Data
public class CheckDateResponse {
    private String name;
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @DateTimeFormat(pattern =  "yyyy-MM-dd'T'HH:mm:ss")
    private Date checkDate;
}
