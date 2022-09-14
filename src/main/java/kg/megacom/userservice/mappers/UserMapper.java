package kg.megacom.userservice.mappers;

import kg.megacom.userservice.mappers.base.CrudMapper;
import kg.megacom.userservice.models.User;
import kg.megacom.userservice.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends CrudMapper<User, UserDto> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

}
