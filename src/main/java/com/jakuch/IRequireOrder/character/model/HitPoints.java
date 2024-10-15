package com.jakuch.IRequireOrder.character.model;

import com.jakuch.IRequireOrder.dice.model.DiceType;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class HitPoints {
    private int currentHp;
    private int maxHp;
    private int temporaryHp;
    private Map<DiceType, Integer> hitDices;
}
