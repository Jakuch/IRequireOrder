package com.jakuch.IRequireOrder.character.service;

import com.jakuch.IRequireOrder.character.form.CharacterForm;
import com.jakuch.IRequireOrder.character.model.Advantage;
import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.character.model.InitiativeBonus;
import com.jakuch.IRequireOrder.level.model.Level;
import com.jakuch.IRequireOrder.character.model.attributes.Attribute;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.character.model.Proficiency;
import com.jakuch.IRequireOrder.character.model.skills.Skill;
import com.jakuch.IRequireOrder.character.repository.CharacterRepository;
import com.jakuch.IRequireOrder.srd.characterClass.service.CharacterClassFetcherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class CharacterService {

    private CharacterRepository characterRepository;
    private CharacterClassFetcherService characterClassFetcherService;

    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    public Character findById(String id) {
        return characterRepository.findById(id).orElseThrow();
    }

    public String saveCharacter(CharacterForm characterForm) {
        return characterRepository.save(dtoToPojo(characterForm)).getId();
    }

    public void deleteCharacter(String id) {
        characterRepository.deleteById(id);
    }

    public void deleteAll() {
        characterRepository.deleteAll();
    }

    private Character dtoToPojo(CharacterForm characterForm) {
        var character = new Character();

        character.setLevel(Level.findByNumericValue(characterForm.getLevel()));
        character.setAttributes(getAttributes(characterForm));

        character.setCurrentExperiencePoints(character.getLevel().getRequiredExperience());
        character.setInitiativeBonus(new InitiativeBonus(character.getAttributes().get(AttributeName.DEXTERITY.name()).getBonus(), Advantage.NONE));
        character.setWalkingSpeed(characterForm.getWalkingSpeed());
        character.setName(characterForm.getName());
        character.setMaxHealth(characterForm.getMaxHealth());
        character.setCurrentHealth(characterForm.getCurrentHealth());
        character.setArmorClass(characterForm.getArmorClass());

        character.getSkills().forEach(skill -> skill.setValue(calculateBonus(skill, character)));

        character.getSavingThrows().forEach(savingThrow -> savingThrow.setValue(calculateBonus(savingThrow, character)));

        character.getCharacterClasses().add(characterClassFetcherService.fetchMappedCharacterClass(characterForm.getCharacterClassSrdKey()));

        return character;
    }

    private int calculateBonus(Skill skill, Character character) {
        int attributeBonus = character.getAttributes().get(skill.getModifier().name()).getBonus();
        int proficiencyBonus = Proficiency.calculateProficiencyBonus(skill.getProficiency(), character.getLevel());

        return attributeBonus + proficiencyBonus;
    }

    private Map<String, Attribute> getAttributes(CharacterForm characterForm) {
        var attributes = new HashMap<String, Attribute>();

        attributes.put(AttributeName.STRENGTH.name(), new Attribute(characterForm.getStrength()));
        attributes.put(AttributeName.DEXTERITY.name(), new Attribute(characterForm.getDexterity()));
        attributes.put(AttributeName.CONSTITUTION.name(), new Attribute(characterForm.getConstitution()));
        attributes.put(AttributeName.INTELLIGENCE.name(), new Attribute(characterForm.getIntelligence()));
        attributes.put(AttributeName.WISDOM.name(), new Attribute(characterForm.getWisdom()));
        attributes.put(AttributeName.CHARISMA.name(), new Attribute(characterForm.getCharisma()));

        return attributes;
    }
}
