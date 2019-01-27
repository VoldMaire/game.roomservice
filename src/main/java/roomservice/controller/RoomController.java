package roomservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import roomservice.datasource.RoomRepository;
import roomservice.entity.Player;
import roomservice.entity.Room;

public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> retrieveAllRooms() {
        return roomRepository.findAll();
    }

//    @PostMapping("/room/create")
//    public Room createRoom(@RequestBody Room room, @RequestBody Player player) {
//
//    }
}
