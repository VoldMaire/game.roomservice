package roomservice.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import roomservice.entity.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
