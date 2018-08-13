package com.pk.rps.utils;

import com.pk.rps.engine.Statistics;
import com.pk.rps.unit.Unit;
import org.springframework.beans.factory.annotation.Value;

import static java.lang.System.out;

public class MessageUtils {

    @Value("${app.rps.hello.message}")
    private String helloMessage;

    @Value("${app.rps.rules.message}")
    private String rulesMessage;

    @Value("${app.rps.invalid.input.message}")
    private String invalidInputMessage;

    @Value("${app.rps.move.invitation.message}")
    private String moveInvitationMessage;

    public void printInitMessages() {
        out.println(helloMessage);
        out.println(rulesMessage);
    }

    public void printInvalidInputMessage() {
        out.println(invalidInputMessage);
    }

    public void printStatistics(Statistics statistics) {
        out.println(statistics);
    }

    public void printMoveInvitationMessage() {
        out.print(moveInvitationMessage);
    }

    public void printEmptyMessage() {
        out.println();
    }

    public void printMessageForVote(int voteResult, Unit userUnit, Unit aiUnit) {
        String message = "Your " + userUnit + " vs my " + aiUnit;
        switch (voteResult) {
            case -1:
                message = message + ": You lost!";
                break;
            case 1:
                message = message + ": You won!";
                break;
            case 0:
                message = message + ": Draw!";
                break;
            default:
                message = "Unit not found";
        }
        out.println(message);
    }

}
