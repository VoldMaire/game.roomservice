package roomservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Player(){}

    public Long getId(){ return id; }

    public String getName(){ return name; }
}
