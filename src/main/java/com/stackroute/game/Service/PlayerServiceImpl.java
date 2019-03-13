package com.stackroute.game.Service;


import com.stackroute.game.Repository.PlayerRepository;
import com.stackroute.game.domain.Player;
import com.stackroute.game.exceptions.PlayerAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerRepository getUserRepository() {
        return playerRepository;
    }

    public void setUserRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }


    public Player savePlayer(Player player) throws PlayerAlreadyExistsException {
        if (playerRepository.existsById(player.getId())) {
            throw new PlayerAlreadyExistsException("Player already exists");
        }
        Player savedPlayer = playerRepository.save(player);

        return savedPlayer;
    }

    public List<Player> getAllPlayer() {
        return (List<Player>) playerRepository.findAll();
    }


    public Optional<Player> retrievePlayerById(int id) {
        Optional<Player> player = playerRepository.findById(id);
        return player;
    }

    public List<Player> retrievePlayerByName(String name) {
        List<Player> player = playerRepository.findByName(name);
        return player;
    }

    public void deletePlayerById(int id) {
        playerRepository.deleteById(id);
    }


}
