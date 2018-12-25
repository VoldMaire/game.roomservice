package roomservice.datasource;

import java.util.List;

import roomservice.entity.Entity;

public interface Repository<T extends Entity> {
    T getById(String id);
    List<T> getAll();//TODO use pagination https://www.baeldung.com/hibernate-pagination
    void put(T entity);
    void putAll(List<T> entityList);
    void delete(T entity);
    void deleteAll(List<T> entityList);
    T update(T entity);
    List<T> updateAll(List<T> entity);
}
