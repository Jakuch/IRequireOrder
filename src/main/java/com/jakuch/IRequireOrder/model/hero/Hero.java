package com.jakuch.IRequireOrder.model.hero;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Hero {
    @Id
    private String id;
    private String name;
//    private Level level; TODO add level as enum with proficency bonus
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private Attributes attributes;
}
