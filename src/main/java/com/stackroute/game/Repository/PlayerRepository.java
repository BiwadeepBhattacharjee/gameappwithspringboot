package com.stackroute.game.Repository;

import com.stackroute.game.domain.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player,Integer> {
}
