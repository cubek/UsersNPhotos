package sk.cubi.usersnphotos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.cubi.usersnphotos.persistence.entity.User;

public interface UserDao extends JpaRepository<User, Long> {

}
