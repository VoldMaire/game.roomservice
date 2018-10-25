package roomservice.datasource;

import roomservice.entity.Room;
import roomservice.entity.User;

public class UnitOfWorkStub implements UnitOfWork{

    @Override
    public Repository<Room> getRoomRepository() {
        return new RoomRepositoryStub();
    }

    @Override
    public Repository<User> getUserRepository() {
        return new UserRepositoryStub();
    }
}
