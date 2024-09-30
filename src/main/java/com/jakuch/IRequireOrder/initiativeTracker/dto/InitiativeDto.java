package com.jakuch.IRequireOrder.initiativeTracker.dto;

import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.initiativeTracker.model.Initiative;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiativeDto {

    private String characterName;
    private Integer value;
    private int armorClass;
    private int currentHp;
    private int maxHp;
    private String notes;

    public Initiative toInitiative(String characterId) {
        Initiative initiative = new Initiative();
        initiative.setValue(this.getValue());
        initiative.setCharacterId(characterId);
        initiative.setNotes(this.getNotes());

        return initiative;
    }

    public Character toCharacter() {
        Character character = new Character();
        character.setName(this.getCharacterName());
        character.setArmorClass(this.getArmorClass());
        character.setCurrentHealth(this.getCurrentHp());
        character.setMaxHealth(this.getMaxHp());
        return character;
    }

    public static InitiativeDto toDto(Initiative initiative, Character character) {
        var initiativeDto = new InitiativeDto();

        initiativeDto.setValue(initiative.getValue());
        initiativeDto.setNotes(initiative.getNotes());

        initiativeDto.setCharacterName(character.getName());
        initiativeDto.setArmorClass(character.getArmorClass());
        initiativeDto.setCurrentHp(character.getCurrentHealth());
        initiativeDto.setMaxHp(character.getMaxHealth());


        return initiativeDto;
    }
}
