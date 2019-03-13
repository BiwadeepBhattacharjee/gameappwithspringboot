package com.stackroute.game.starter;

import com.stackroute.game.Repository.PlayerRepository;
import com.stackroute.game.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StartupCommandLineRunner implements CommandLineRunner {
    PlayerRepository playerRepository;
    @Autowired
    Environment environment;

    @Value("${id:default}")
    int id;


    @Value("${score:default}")
    int score;

    @Autowired
    public StartupCommandLineRunner(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;

    }

    @Override
    public void run(String... args) throws Exception {
        playerRepository.save(new Player(id, environment.getProperty("name"), score));
    }
}
