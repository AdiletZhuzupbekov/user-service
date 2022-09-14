package kg.megacom.userservice.mappers;

import kg.megacom.userservice.mappers.base.CrudMapper;
import kg.megacom.userservice.models.User;
import kg.megacom.userservice.response.CheckDateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CheckDateResponseMapper extends CrudMapper<User, CheckDateResponse> {
    CheckDateResponseMapper INSTANCE = Mappers.getMapper(CheckDateResponseMapper.class);


    @Override
    @Mapping(source = "userStatus",target = "userStatus")
    List<CheckDateResponse> toDtoList(List<User> users);


}
