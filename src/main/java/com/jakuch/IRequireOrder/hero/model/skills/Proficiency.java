package com.jakuch.IRequireOrder.hero.model.skills;

import com.jakuch.IRequireOrder.hero.model.Level;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Proficiency {
    private ProficiencyName name;
    private int value;

    public Proficiency(ProficiencyName name, Level level) {
        this.name = name;
        calculateValue(name, level);
    }

    private void calculateValue(ProficiencyName name, Level level) {
        switch (name) {
            case HALF -> value = level.getProficiencyBonus() /2;
            case FULL -> value = level.getProficiencyBonus();
            case EXPERTISE -> value = level.getProficiencyBonus()*2;
        }
    }
}
