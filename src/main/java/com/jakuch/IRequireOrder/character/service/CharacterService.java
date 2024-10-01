package com.jakuch.IRequireOrder.character.service;

import com.jakuch.IRequireOrder.character.dto.CharacterDto;
import com.jakuch.IRequireOrder.character.model.Advantage;
import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.character.model.InitiativeBonus;
import com.jakuch.IRequireOrder.character.model.Level;
import com.jakuch.IRequireOrder.character.model.attributes.Attribute;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.character.model.Proficiency;
import com.jakuch.IRequireOrder.character.model.skills.Skill;
import com.jakuch.IRequireOrder.character.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CharacterService {

    private CharacterRepository characterRepository;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findById(String id) {
        return characterRepository.findById(id).orElseThrow();
    }

    public String saveCharacter(CharacterDto characterDto) {
        return characterRepository.save(dtoToPojo(characterDto)).getId();
    }

    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }

    public void deleteAll() {
        characterRepository.deleteAll();
    }

    private Character dtoToPojo(CharacterDto characterDto) {
        var character = new Character();

        character.setLevel(Level.findByNumericValue(characterDto.getLevel()));
        character.setAttributes(getAttributes(characterDto));

        character.setCurrentExperiencePoints(character.getLevel().getRequiredExperience());
        character.setInitiativeBonus(new InitiativeBonus(character.getAttributes().get(AttributeName.DEXTERITY).getBonus(), Advantage.NONE));
        character.setWalkingSpeed(characterDto.getWalkingSpeed());
        character.setName(characterDto.getName());
        character.setMaxHealth(characterDto.getMaxHealth());
        character.setCurrentHealth(characterDto.getCurrentHealth());
        character.setArmorClass(characterDto.getArmorClass());

        character.getSkills().forEach(skill -> {
            skill.setValue(calculateSkillBonus(skill, character));
        });

        return character;
    }

    private int calculateSkillBonus(Skill skill, Character character) {
        int attributeBonus = character.getAttributes().get(skill.getModifier()).getBonus();
        int proficiencyBonus = Proficiency.calculateProficiencyBonus(skill.getProficiency(), character.getLevel());

        return attributeBonus + proficiencyBonus;
    }

    private Map<AttributeName, Attribute> getAttributes(CharacterDto characterDto) {
        var attributes = new HashMap<AttributeName, Attribute>();

        attributes.put(AttributeName.STRENGTH, new Attribute(characterDto.getStrength()));
        attributes.put(AttributeName.DEXTERITY, new Attribute(characterDto.getDexterity()));
        attributes.put(AttributeName.CONSTITUTION, new Attribute(characterDto.getConstitution()));
        attributes.put(AttributeName.INTELLIGENCE, new Attribute(characterDto.getIntelligence()));
        attributes.put(AttributeName.WISDOM, new Attribute(characterDto.getWisdom()));
        attributes.put(AttributeName.CHARISMA, new Attribute(characterDto.getCharisma()));

        return attributes;
    }
}
