package kg.megacom.userservice.service.impl;

import kg.megacom.userservice.mappers.CheckDateResponseMapper;
import kg.megacom.userservice.models.User;
import kg.megacom.userservice.models.enums.UserStatus;
import kg.megacom.userservice.repository.UserRepo;
import kg.megacom.userservice.response.CheckDateResponse;
import kg.megacom.userservice.service.DateRequestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DateRequestServiceImpl implements DateRequestService {
    private final UserRepo userRepo;
    private final CheckDateResponseMapper checkDateResponseMapper;

    public DateRequestServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
        this.checkDateResponseMapper = CheckDateResponseMapper.INSTANCE;
    }

    @Override
    public List<CheckDateResponse> getUsersByStatus(UserStatus userStatus, Date date) {
        List<User> users = userRepo.findAll();
        List<CheckDateResponse> checkDateResponses;
        if (userStatus!=null&& date==null) {
            users = users
                    .stream()
                    .filter(x -> x.getUserStatus() == userStatus)
                    .collect(Collectors.toList());
        }else if (date!=null && userStatus==null){
            users = users
                    .stream()
                    .filter(x -> x.getCheckDate().getTime() > date.getTime())
                    .collect(Collectors.toList());
        }else if (userStatus!=null && date!=null) {
            users = users
                    .stream()
                    .filter(x -> x.getUserStatus() == userStatus && x.getCheckDate().getTime() > date.getTime())
                    .collect(Collectors.toList());
        }
        checkDateResponses = checkDateResponseMapper.toDtoList(users);

        checkDateResponses = checkDateResponses
                .stream()
                .peek(x -> x.setCheckDate(addHoursToJavaUtilDate(x.getCheckDate())))
                .collect(Collectors.toList());

        return checkDateResponses;
    }

    public Date addHoursToJavaUtilDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, 6);
        return calendar.getTime();
    }

}
