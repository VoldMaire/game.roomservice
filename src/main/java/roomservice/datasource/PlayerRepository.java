package roomservice.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import roomservice.entity.Player;

public interface UserRepository extends JpaRepository<Player, Long> {

}
