package com.jakuch.IRequireOrder.character.model.attributes;

import lombok.Data;

@Data
public class Attribute {
    private int value;
    private int bonus;

    public Attribute(int value) {
        this.value = value;
        calculateBonus();
    }

    private void calculateBonus() {
        this.bonus = (this.value-10)/2;
    }
}