package com.stackroute.game.Controller;


import com.stackroute.game.Service.PlayerServiceImpl;
import com.stackroute.game.domain.Player;
import com.stackroute.game.exceptions.PlayerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class PlayerController {

    private PlayerServiceImpl playerService;

    @Autowired
    public PlayerController(PlayerServiceImpl playerService) {
        this.playerService = playerService;
    }

    @PostMapping("player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) throws PlayerAlreadyExistsException {
        ResponseEntity responseEntity;

        Player savedPlayer = playerService.savePlayer(player);

        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);


    }

    @GetMapping("/players")
    public List<Player> getAllPlayer() {
        List<Player> players = playerService.getAllPlayer();
        return players;
    }

    @GetMapping("/players/{name}")
    public List<Player> searchByName(@PathVariable String name) {
        List<Player> player = playerService.retrievePlayerByName(name);

        return player;
    }


    @GetMapping("/player/{id}")
    public Player retrievePlayerById(@PathVariable int id) {
        Optional<Player> player = playerService.retrievePlayerById(id);

        return player.get();
    }

    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayerById(id);
    }
}
