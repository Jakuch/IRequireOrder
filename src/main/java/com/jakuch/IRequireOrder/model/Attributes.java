package com.jakuch.IRequireOrder.model;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Attributes {

    @Id
    private String id;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attributes that)) return false;
        return strength == that.strength && dexterity == that.dexterity && constitution == that.constitution && intelligence == that.intelligence && wisdom == that.wisdom && charisma == that.charisma && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, strength, dexterity, constitution, intelligence, wisdom, charisma);
    }

    //    private Attributes(AttributeBuilder attributeBuilder) {
//        this.strength = attributeBuilder.strength;
//        this.dexterity = attributeBuilder.dexterity;
//        this.constitution = attributeBuilder.constitution;
//        this.intelligence = attributeBuilder.intelligence;
//        this.wisdom = attributeBuilder.wisdom;
//        this.charisma = attributeBuilder.charisma;
//    }
//
//    public static class AttributeBuilder {
//        private int strength;
//        private int dexterity;
//        private int constitution;
//        private int intelligence;
//        private int wisdom;
//        private int charisma;
//
//        public Attributes build() {
//            return new Attributes(this);
//        }
//
//        public Attributes buildWithTens() {
//            this.strength = 10;
//            this.dexterity = 10;
//            this.constitution = 10;
//            this.intelligence = 10;
//            this.wisdom = 10;
//            this.charisma = 10;
//            return new Attributes(this);
//        }
//    }
}
