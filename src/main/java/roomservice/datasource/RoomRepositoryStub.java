package roomservice.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import roomservice.entity.Room;

public class RoomRepositoryStub implements Repository<Room> {

    static List<Room> rooms = Collections.synchronizedList(new ArrayList<>());

    @Override
    public Room getById(String id) {
        Room result = null;
        synchronized (rooms) {
            result = rooms.stream()
                          .filter(r -> r.getId() == id)
                          .findFirst()
                          .get();
        }
        return result;
    }

    @Override
    public List<Room> getAll() {
        return Collections.unmodifiableList(rooms);
    }

    @Override
    public void put(Room entity) {
            rooms.add(entity);
    }

    @Override
    public void putAll(List<Room> entityList) {
        rooms.addAll(entityList);
    }

    @Override
    public void delete(Room entity) {
        rooms.remove(entity);
    }

    @Override
    public void deleteAll(List<Room> entityList) {
        rooms.removeAll(entityList);
    }

    @Override
    public Room update(Room entity) {
        delete(getById(entity.getId()));
        put(entity);
        return entity;
    }

    @Override
    public List<Room> updateAll(List<Room> entity) {
        synchronized (rooms) {
            entity.stream().forEach(e -> update(e));
        }
        return entity;
    }
}
