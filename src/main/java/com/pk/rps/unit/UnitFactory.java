package com.pk.rps.unit;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface UnitFactory {

    static Map<Integer, Unit> getUnitMap() {
        Map<Integer, Unit> unitMap = new HashMap<>();
        unitMap.put(1, getRock());
        unitMap.put(2, getPaper());
        unitMap.put(3, getScissors());
        return unitMap;
    }

    static Unit getRock() {
        Unit rock = new Unit();
        rock.setId(1);
        rock.setName("Rock");
        rock.setLosesTo(Collections.singleton(2));
        return rock;
    }

    static Unit getPaper() {
        Unit paper = new Unit();
        paper.setId(2);
        paper.setName("Paper");
        paper.setLosesTo(Collections.singleton(3));
        return paper;
    }

    static Unit getScissors() {
        Unit scissors = new Unit();
        scissors.setId(3);
        scissors.setName("Scissors");
        scissors.setLosesTo(Collections.singleton(1));
        return scissors;
    }
}
