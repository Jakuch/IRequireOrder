package com.jakuch.IRequireOrder.model.hero.dto;

import com.jakuch.IRequireOrder.model.hero.Attributes;
import com.jakuch.IRequireOrder.model.hero.Hero;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    public HeroDto() {
    }

    public Hero toHero() {
        var hero = new Hero();
        hero.setName(this.name);
        hero.setMaxHealth(this.maxHealth);
        hero.setCurrentHealth(this.currentHealth);
        hero.setArmorClass(this.armorClass);
        hero.setAttributes(getAttributes());

        return hero;
    }

    private Attributes getAttributes() {
        var attributes = new Attributes();
        attributes.setStrength(this.strength);
        attributes.setDexterity(this.dexterity);
        attributes.setConstitution(this.constitution);
        attributes.setIntelligence(this.intelligence);
        attributes.setWisdom(this.wisdom);
        attributes.setCharisma(this.charisma);

        return attributes;
    }
}
