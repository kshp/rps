package com.pk.rps.engine;

import com.pk.rps.unit.Unit;
import com.pk.rps.utils.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    @Autowired
    private MessageUtils messageUtils;

    @Autowired
    private MarkovChain markovChain;

    @Autowired
    private Statistics statistics;

    @Autowired
    private Map<Integer, Unit> unitMap;

    public void playGame() {
        messageUtils.printInitMessages();
        messageUtils.printEmptyMessage();

        try (Scanner scanner = new Scanner(System.in)) {
            boolean running = Boolean.TRUE;
            while (running) {
                messageUtils.printMoveInvitationMessage();
                running = processInput(scanner.nextInt());
            }
        }
        messageUtils.printStatistics(statistics);
    }

    private Boolean processInput(int userInput) {
        if (userInput == 0) {
            return Boolean.FALSE;
        }
        if (userInput < 0 || userInput > unitMap.size()) {
            messageUtils.printInvalidInputMessage();
            return Boolean.TRUE;
        }

        Integer nextAiMove = markovChain.nextMove();
        markovChain.updateChain();

        Unit userUnit = unitMap.get(userInput);
        Unit aiUnit = unitMap.get(nextAiMove);

        int voteResult = userUnit.voteAgainst(aiUnit);
        statistics.addResult(voteResult);

        messageUtils.printMessageForVote(voteResult, userUnit, aiUnit);
        messageUtils.printEmptyMessage();

        return Boolean.TRUE;
    }

}
