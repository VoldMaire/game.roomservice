package roomservice.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import roomservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
