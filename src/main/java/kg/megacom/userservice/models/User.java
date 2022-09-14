package kg.megacom.userservice.models;

import kg.megacom.userservice.models.enums.UserStatus;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String imgUrl;
    @Enumerated(EnumType.STRING)
    private UserStatus userStatus;
    @DateTimeFormat(pattern =  "yyyy-MM-dd'T'HH:mm:ss")
    private Date checkDate;

}
