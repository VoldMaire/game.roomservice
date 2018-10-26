package roomservice.entity;

import java.util.UUID;

public class Entity {

    private String id;
    private String name;

    public Entity(){this.id = UUID.randomUUID().toString();}

    //TODO use lombok for plain java
    public Entity(String name) {
        this();
        this.name = name;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
