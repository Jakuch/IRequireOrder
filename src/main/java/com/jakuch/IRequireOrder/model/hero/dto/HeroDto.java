package com.jakuch.IRequireOrder.model.hero.dto;

import com.jakuch.IRequireOrder.model.hero.Attributes;
import com.jakuch.IRequireOrder.model.hero.Hero;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }
}
