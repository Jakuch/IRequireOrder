package com.jakuch.IRequireOrder.model.hero.dto;

import com.jakuch.IRequireOrder.model.hero.Advantage;
import com.jakuch.IRequireOrder.model.hero.InitiativeBonus;
import com.jakuch.IRequireOrder.model.hero.attributes.Attributes;
import com.jakuch.IRequireOrder.model.hero.Hero;
import com.jakuch.IRequireOrder.model.hero.Level;
import com.jakuch.IRequireOrder.model.hero.attributes.Attribute;
import com.jakuch.IRequireOrder.model.hero.attributes.AttributeName;
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
    private int level;
    private int initiativeBonus;
    private int walkingSpeed;

    public HeroDto() {
    }

    public Hero toHero() {
        var hero = new Hero();

        hero.setLevel(Level.findByNumericValue(level));
        hero.setAttributes(getAttributes());
        hero.setCurrentExperiencePoints(hero.getLevel().getRequiredExperience());
        hero.setInitiativeBonus(new InitiativeBonus(hero.getAttributes().getDexterity().getBonus(), Advantage.NONE));
        hero.setWalkingSpeed(this.walkingSpeed);
        hero.setName(this.name);
        hero.setMaxHealth(this.maxHealth);
        hero.setCurrentHealth(this.currentHealth);
        hero.setArmorClass(this.armorClass);

        return hero;
    }

    private Attributes getAttributes() {
        var attributes = new Attributes();
        attributes.setStrength(new Attribute(AttributeName.STRENGTH, this.strength));
        attributes.setDexterity(new Attribute(AttributeName.DEXTERITY, this.dexterity));
        attributes.setConstitution(new Attribute(AttributeName.CONSTITUTION, this.constitution));
        attributes.setIntelligence(new Attribute(AttributeName.INTELLIGENCE, this.intelligence));
        attributes.setWisdom(new Attribute(AttributeName.WISDOM, this.wisdom));
        attributes.setCharisma(new Attribute(AttributeName.CHARISMA, this.charisma));

        return attributes;
    }
}
