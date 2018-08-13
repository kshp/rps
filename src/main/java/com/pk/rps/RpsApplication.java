package com.pk.rps;

import com.pk.rps.engine.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpsApplication implements CommandLineRunner {

    @Autowired
    private GameEngine gameEngine;

    public static void main(String[] args) {
        SpringApplication.run(RpsApplication.class, args);
    }

    @Override
    public void run(String... args) {
        gameEngine.playGame();
    }

}
