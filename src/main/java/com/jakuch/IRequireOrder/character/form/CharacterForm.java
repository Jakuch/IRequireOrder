package com.jakuch.IRequireOrder.character.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CharacterForm { //TODO its actually for removal Character class should be enough (so whole characterAdd revamp)
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;
    private int level;
    private int walkingSpeed;
    private String characterClassSrdKey;
    private String raceSrdKey;
}
