package com.stackroute.game.Service;

import com.stackroute.game.domain.Player;
import com.stackroute.game.exceptions.PlayerAlreadyExistsException;

public interface PlayerService {
    public Player savePlayer(Player player) throws PlayerAlreadyExistsException;
}
