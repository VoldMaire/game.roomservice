package roomservice.entity;

import java.util.ArrayList;
import java.util.List;

public class Room extends Entity{

    private int gameId;
    private List<User> users = new ArrayList<>();
    private int countUser;

    public Room(){}

    public Room(long id, String name, int gameId, int countUser){
        super(id, name);
        this.gameId = gameId;
        this.countUser = countUser;
    }

    public long getGameId(){
        return gameId;
    }
}
