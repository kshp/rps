package com.pk.rps.engine;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class MarkovChain {

    @Autowired
    private Random random;

    private float[][] markovChainArr;
    private int[] timesPlayedArr;

    private int lastMove;
    private int beforeLastMove;

    public MarkovChain() {
        markovChainArr = new float[][]{{0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}, {0.33f, 0.33f, 0.33f}};
        timesPlayedArr = new int[]{0, 0, 0};
    }

    Integer nextMove() {
        float ranFloat = random.nextFloat();
        beforeLastMove = lastMove;
        if (ranFloat <= markovChainArr[lastMove][1]) {
            lastMove = 0;
            return 1; //Rock
        } else if (ranFloat <= markovChainArr[lastMove][2] + markovChainArr[lastMove][1]) {
            lastMove = 1;
            updateChain();
            return 2; //Paper
        }
        lastMove = 2;
        return 3;//Scissors
    }

    void updateChain() {
        for (int i = 0; i < 3; i++)
            markovChainArr[beforeLastMove][i] *= timesPlayedArr[beforeLastMove];

        markovChainArr[beforeLastMove][lastMove] += 1;
        timesPlayedArr[beforeLastMove]++;

        for (int j = 0; j < 3; j++) {
            markovChainArr[beforeLastMove][j] /= timesPlayedArr[beforeLastMove];
        }
    }
}
