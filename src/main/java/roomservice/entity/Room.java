package roomservice.entity;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    private int gameId;
    private int countUser;

    public Room(){
        super();
    }

}
