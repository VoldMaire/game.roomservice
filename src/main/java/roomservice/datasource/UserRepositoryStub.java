package roomservice.datasource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import roomservice.entity.User;

public class UserRepositoryStub implements Repository<User>{

    static List<User> users = Collections.synchronizedList(new ArrayList<>());

    @Override
    public User getById(int id) {
        synchronized (users) {
            return users.stream()
                          .filter(r -> r.getId() == id)
                          .findFirst()
                          .get();
        }
    }

    @Override
    public List<User> getAll() {
        return Collections.unmodifiableList(users);
    }

    @Override
    public void put(User entity) {
        users.add(entity);
    }

    @Override
    public void putAll(List<User> entityList) {
        users.addAll(entityList);
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);
    }

    @Override
    public void deleteAll(List<User> entityList) {
        users.removeAll(entityList);
    }

    @Override
    public User update(User entity) {
        delete(getById((int)entity.getId()));
        put(entity);
        return entity;
    }

    @Override
    public List<User> updateAll(List<User> entity) {
        synchronized (users) {
            entity.stream().forEach(e -> update(e));
        }
        return entity;
    }
}
