package roomservice.datasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import roomservice.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

}
