package roomservice.datasource;

import roomservice.entity.Room;
import roomservice.entity.User;

public interface UnitOfWork {
    Repository<Room> getRoomRepository();
    Repository<User> getUserRepository();
}
