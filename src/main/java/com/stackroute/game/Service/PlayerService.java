package com.stackroute.game.Service;

import com.stackroute.game.domain.Player;
import com.stackroute.game.exceptions.PlayerAlreadyExistsException;

import java.util.List;
import java.util.Optional;

public interface PlayerService {
    public Player savePlayer(Player player) throws PlayerAlreadyExistsException;

    public List<Player> getAllPlayer();

    public Optional<Player> retrievePlayerById(int id);

    public List<Player> retrievePlayerByName(String name);

    public void deletePlayerById(int id);
}
