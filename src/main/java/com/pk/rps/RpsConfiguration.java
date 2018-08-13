package com.pk.rps;

import com.pk.rps.engine.GameEngine;
import com.pk.rps.engine.MarkovChain;
import com.pk.rps.engine.Statistics;
import com.pk.rps.unit.Unit;
import com.pk.rps.unit.UnitFactory;
import com.pk.rps.utils.MessageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Random;

@Configuration
public class RpsConfiguration {

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public Map<Integer, Unit> unitMap() {
        return UnitFactory.getUnitMap();
    }

    @Bean
    public GameEngine gameEngine() {
        return new GameEngine();
    }

    @Bean
    public MessageUtils messageUtils() {
        return new MessageUtils();
    }

    @Bean
    public Statistics statistics() {
        return new Statistics();
    }

    @Bean
    public MarkovChain markovChain() {
        return new MarkovChain();
    }
}
