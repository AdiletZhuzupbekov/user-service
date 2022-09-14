package kg.megacom.userservice.models.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class UserDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String phone;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imgUrl;

}
