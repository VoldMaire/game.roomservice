package roomservice.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import roomservice.entity.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
