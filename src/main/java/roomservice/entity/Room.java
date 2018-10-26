package roomservice.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Room extends Entity{

    private int gameId;
    private List<User> users = new ArrayList<>();
    private int countUser;
    private UUID identifier;

    public Room(){
        super();
    }

    public Room(String name, int gameId, int countUser){
        super(name);
        this.gameId = gameId;
        this.countUser = countUser;
    }

    public long getGameId(){
        return gameId;
    }
}
