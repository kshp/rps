package com.pk.rps.unit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id", "name"})
public class Unit {

    private Integer id;
    private String name;
    private Set<Integer> losesTo;

    public int voteAgainst(Unit unit) {
        if (this.equals(unit))
            return 0;
        return losesTo.contains(unit.id) ? -1 : 1;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
