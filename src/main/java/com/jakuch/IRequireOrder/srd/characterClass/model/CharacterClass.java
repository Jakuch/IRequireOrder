package com.jakuch.IRequireOrder.srd.characterClass.model;

import com.jakuch.IRequireOrder.dice.model.DiceType;
import com.jakuch.IRequireOrder.level.model.Level;
import com.jakuch.IRequireOrder.srd.SrdData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CharacterClass extends SrdData {

    private Level level;
    private String subclassSrdKey;
    private DiceType hitDice;

    public CharacterClass(String name, String srdKey) {
        this.name = name;
        this.srdKey = srdKey;
        this.level = Level.FIRST;
    }
}
