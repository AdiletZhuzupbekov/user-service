package kg.megacom.userservice.repository;

import kg.megacom.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<User> findAllByCheckDate(Date date);
}
