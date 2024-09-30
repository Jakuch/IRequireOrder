package com.jakuch.IRequireOrder.character.model;

import com.jakuch.IRequireOrder.character.model.attributes.Attribute;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.character.model.attributes.AttributesInitializer;
import com.jakuch.IRequireOrder.character.model.savingThrows.SavingThrow;
import com.jakuch.IRequireOrder.character.model.savingThrows.SavingThrowInitializer;
import com.jakuch.IRequireOrder.character.model.skills.Skill;
import com.jakuch.IRequireOrder.character.model.skills.SkillsInitializer;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Map;

@Data
public class Character {
    @Id
    private String id;
    private String name;
    private int maxHealth;
    private int currentHealth;
    private int armorClass;
    private int walkingSpeed;
    private InitiativeBonus initiativeBonus;
    private Map<AttributeName, Attribute> attributes = AttributesInitializer.initializeDefaultAttributes();
    private Level level;
    private int currentExperiencePoints;
    private List<Skill> skills = SkillsInitializer.initializeSkills();
    private List<SavingThrow> savingThrows = SavingThrowInitializer.initializeSavingThrows();
    // private Class class; TODO that should be taken from sources
    // private Race race; TODO that should be taken from sources
    // private PassiveSenses passiveSenses;

    // private AdditionalInformation additionalInformation; TODO add here background, player, alignment, etc.
    // private Proficiencies proficiencies
    // private List<Object> customData; TODO move it to AdditionalInformation when its implemented

    public void addCustomSkill(Skill skill) {
        skills.add(skill);
    }

    public void removeCustomSkill(String name) {
        var baseSkills = SkillsInitializer.initializeSkills();
        if (baseSkills.stream().anyMatch(el -> el.getName().equals(name))) {
            throw new UnsupportedOperationException("You can't remove base skills!");
        } else {
            this.skills.removeIf(el -> el.getName().equals(name));
        }
    }


}
