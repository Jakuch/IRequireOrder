package com.jakuch.IRequireOrder.model.hero;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Hero {

    @Id
    private String id;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private Attributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero hero)) return false;
        return Objects.equals(id, hero.id) && Objects.equals(name, hero.name) && Objects.equals(attributes, hero.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, attributes);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", maxHealth=" + maxHealth +
                ", currentHealth=" + currentHealth +
                ", armorClass=" + armorClass +
                ", attributes=" + attributes +
                '}';
    }
}
