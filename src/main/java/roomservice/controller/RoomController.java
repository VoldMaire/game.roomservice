package roomservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import roomservice.datasource.UnitOfWork;
import roomservice.entity.Room;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class RoomController {

    @Autowired
    private UnitOfWork datasource;

    @GetMapping(value = "/rooms", produces = "application/json")
    public List<Room> rooms(){
        return datasource.getRoomRepository().getAll();
    }

    @PostMapping(value = "/room/create", consumes = {"application/json"})
    public void create(@RequestBody Room newRoom){
        datasource.getRoomRepository().put(newRoom);
    }

}
