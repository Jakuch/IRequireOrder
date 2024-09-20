package com.jakuch.IRequireOrder.hero.model.attributes;

import lombok.Data;

@Data
public class Attribute {
    private AttributeName name;
    private int value;
    private int bonus;

    public Attribute(AttributeName name, int value) {
        this.name = name;
        this.value = value;
        calculateBonus();
    }

    private void calculateBonus() {
        this.bonus = (this.value-10)/2;
    }
}
