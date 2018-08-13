package com.pk.rps;

import com.pk.rps.engine.Statistics;
import com.pk.rps.unit.Unit;
import com.pk.rps.unit.UnitFactory;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class RpsApplicationTests {

    @Test
    public void testRpsUnitVotes() {
        Unit rock = UnitFactory.getRock();
        Unit paper = UnitFactory.getPaper();
        Unit scissors = UnitFactory.getScissors();

        assertThat(rock.voteAgainst(paper), is(equalTo(-1)));
        assertThat(rock.voteAgainst(scissors), is(equalTo(1)));
        assertThat(rock.voteAgainst(rock), is(equalTo(0)));

        assertThat(paper.voteAgainst(scissors), is(equalTo(-1)));
        assertThat(paper.voteAgainst(rock), is(equalTo(1)));
        assertThat(paper.voteAgainst(paper), is(equalTo(0)));

        assertThat(scissors.voteAgainst(rock), is(equalTo(-1)));
        assertThat(scissors.voteAgainst(paper), is(equalTo(1)));
        assertThat(scissors.voteAgainst(scissors), is(equalTo(0)));
    }

    @Test
    public void testStatisticsCalculation() {
        Statistics statistics = Statistics.buildNew();
        statistics.setLoses(10);
        statistics.setWins(3);

        assertThat(statistics.getWinPercentage(), is(equalTo(BigDecimal.valueOf(23))));
        assertThat(statistics.getLosePercentage(), is(equalTo(BigDecimal.valueOf(77))));
        System.out.println(statistics);
        assertThat(statistics.getLosePercentage()
                        .add(statistics.getWinPercentage())
                        .add(statistics.getDrawsPercentage()),
                is(equalTo(BigDecimal.valueOf(100))));

        statistics = Statistics.buildNew();
        statistics.setLoses(10);
        statistics.setWins(3);
        statistics.setDraws(2);

        assertThat(statistics.getWinPercentage(), is(equalTo(BigDecimal.valueOf(20))));
        assertThat(statistics.getLosePercentage(), is(equalTo(BigDecimal.valueOf(67))));
        assertThat(statistics.getDrawsPercentage(), is(equalTo(BigDecimal.valueOf(13))));
        assertThat(statistics.getLosePercentage()
                        .add(statistics.getWinPercentage())
                        .add(statistics.getDrawsPercentage()),
                is(equalTo(BigDecimal.valueOf(100))));
    }

}
