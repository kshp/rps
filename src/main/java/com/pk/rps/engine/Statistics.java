package com.pk.rps.engine;

import lombok.Data;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
public class Statistics {
    private Integer wins;
    private Integer loses;
    private Integer draws;

    public Statistics() {
        this.wins = 0;
        this.loses = 0;
        this.draws = 0;
    }

    public static Statistics buildNew() {
        return new Statistics();
    }

    void addResult(int result) {
        switch (result) {
            case -1:
                loses++;
                break;
            case 0:
                draws++;
                break;
            case 1:
                wins++;
                break;
            default:
        }
    }

    public BigDecimal getWinPercentage() {
        return isStatisticsEmpty()
                ? BigDecimal.valueOf(0)
                : BigDecimal.valueOf((100D / (wins + loses + draws)) * wins)
                .setScale(0, RoundingMode.HALF_UP);
    }

    public BigDecimal getLosePercentage() {
        return isStatisticsEmpty()
                ? BigDecimal.valueOf(0)
                : BigDecimal.valueOf((100D / (wins + loses + draws)) * loses)
                .setScale(0, RoundingMode.HALF_UP);
    }

    public BigDecimal getDrawsPercentage() {
        return isStatisticsEmpty()
                ? BigDecimal.valueOf(0)
                : BigDecimal.valueOf((100D / (wins + loses + draws)) * draws)
                .setScale(0, RoundingMode.HALF_UP);
    }

    private Boolean isStatisticsEmpty() {
        return wins + draws + loses == 0;
    }

    @Override
    public String toString() {
        return "Statistics: Wins=" + wins + " (" + getWinPercentage()
                + "%), Draws=" + draws + " (" + getDrawsPercentage()
                + "%), Loses=" + loses + " (" + getLosePercentage() + "%)";
    }
}
