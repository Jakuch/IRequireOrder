package com.jakuch.IRequireOrder.hero.model;

import lombok.Data;

@Data
public class InitiativeBonus {
    private int value;
    private Advantage advantage;

    public InitiativeBonus(int value, Advantage advantage) {
        this.value = value;
        this.advantage = advantage;
    }
}
