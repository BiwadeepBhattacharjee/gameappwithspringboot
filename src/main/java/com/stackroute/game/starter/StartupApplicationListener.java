package com.stackroute.game.starter;

import com.stackroute.game.Repository.PlayerRepository;
import com.stackroute.game.domain.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


@Component
@PropertySource("classpath:application.properties")
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    Environment environment;

    @Value("${id:default}")
    int id;



    @Value("${score:default}")
    int score;

        private PlayerRepository playerRepository;

        @Autowired
        public StartupApplicationListener(PlayerRepository playerRepository){
            this.playerRepository=playerRepository;

        }

        @Override
        public void onApplicationEvent(ContextRefreshedEvent event) {
            playerRepository.save(new Player(id,environment.getProperty("name"),score));

        }

}
