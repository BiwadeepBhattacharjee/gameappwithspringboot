package com.stackroute.game.Repository;

import com.stackroute.game.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends CrudRepository<Player,Integer> {
//    @Query(value="Select * from Player where id=?1 ",nativeQuery = true)
//    Player searchByID(int id);

    @Query(value="Select * from Player where name=?1 ",nativeQuery = true)
    List<Player> findByName(String name);


}
