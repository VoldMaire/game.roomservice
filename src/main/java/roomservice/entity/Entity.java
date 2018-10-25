package roomservice.entity;

public class Entity {

    private long id;
    private String name;

    public Entity(){}

    //TODO use lombok for plain java
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
