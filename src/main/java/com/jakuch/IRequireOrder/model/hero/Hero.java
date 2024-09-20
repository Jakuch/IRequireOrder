package com.jakuch.IRequireOrder.model.hero;

import com.jakuch.IRequireOrder.model.hero.attributes.Attributes;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Hero {
    @Id
    private String id;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private int walkingSpeed;
    private InitiativeBonus initiativeBonus;
    private Attributes attributes;
    private Level level;
    private int currentExperiencePoints;
    // private Class class;
    // private Race race;


    // private PassiveSenses passiveSenses;
    // private AdditionalInformation additionalInformation; TODO add here background, player, alignment, etc.
    // private Proficiencies proficiencies
    // private List<Object> customData;

}
