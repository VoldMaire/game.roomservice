package roomservice.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import roomservice.datasource.PlayerRepository;
import roomservice.entity.Player;

@RestController
public class PlayerResource {

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/player")
    public Player retrievePlayer(Long id) {
        return playerRepository.getOne(id);
    }

    @GetMapping("/players")
    public List<Player> retrieveAllPlayers() {
        return playerRepository.findAll();
    }

    @PostMapping("/player")
    public ResponseEntity<Object> createStudent(@RequestBody Player player) {
        Player savedPlayer = playerRepository.save(player);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                                  .buildAndExpand(savedPlayer.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


}
