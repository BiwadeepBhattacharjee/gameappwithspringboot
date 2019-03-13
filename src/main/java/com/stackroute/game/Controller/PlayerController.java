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


    //This method will save a new player if the player already does not exist with the same ID
    @PostMapping("player")
    public ResponseEntity<Player> savePlayer(@RequestBody Player player) throws PlayerAlreadyExistsException {
        ResponseEntity responseEntity;

        Player savedPlayer = playerService.savePlayer(player);

        return new ResponseEntity<>(savedPlayer, HttpStatus.OK);
    }


    //This method will retrieve the datails of all the players
    @GetMapping("/players")
    public List<Player> getAllPlayer() {
        List<Player> players = playerService.getAllPlayer();
        return players;
    }

    //This method retrieves the details of player on the basis of player's name
    @GetMapping("/players/{name}")
    public ResponseEntity<List> searchByName(@PathVariable String name) {
        List<Player> player = playerService.retrievePlayerByName(name);

        return new ResponseEntity<List>(player, HttpStatus.FOUND);
    }


    //This method is used to retrieve a player by id
    @GetMapping("/player/{id}")
    public Player retrievePlayerById(@PathVariable int id) {
        Optional<Player> player = playerService.retrievePlayerById(id);

        return player.get();
    }

    //This method is used to delete a player based on id
    @DeleteMapping("/player/{id}")
    public void deletePlayer(@PathVariable int id) {
        playerService.deletePlayerById(id);
    }
}
