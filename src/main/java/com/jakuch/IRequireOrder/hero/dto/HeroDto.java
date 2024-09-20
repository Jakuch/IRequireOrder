package com.jakuch.IRequireOrder.hero.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class HeroDto {
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
    private int initiativeBonus;
    private int walkingSpeed;
}
