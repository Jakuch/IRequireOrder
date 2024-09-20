package com.jakuch.IRequireOrder.initiativeTracker.dto;

import com.jakuch.IRequireOrder.hero.model.Hero;
import com.jakuch.IRequireOrder.initiativeTracker.model.Initiative;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InitiativeDto {

    private String heroName;
    private Integer value;
    private int armorClass;
    private int currentHp;
    private int maxHp;
    private String notes;

    public Initiative toInitiative(String heroId) {
        Initiative initiative = new Initiative();
        initiative.setValue(this.getValue());
        initiative.setHeroId(heroId);
        initiative.setNotes(this.getNotes());

        return initiative;
    }

    public Hero toHero() {
        Hero hero = new Hero();
        hero.setName(this.getHeroName());
        hero.setArmorClass(this.getArmorClass());
        hero.setCurrentHealth(this.getCurrentHp());
        hero.setMaxHealth(this.getMaxHp());
        return hero;
    }

    public static InitiativeDto toDto(Initiative initiative, Hero hero) {
        var initiativeDto = new InitiativeDto();

        initiativeDto.setValue(initiative.getValue());
        initiativeDto.setNotes(initiative.getNotes());

        initiativeDto.setHeroName(hero.getName());
        initiativeDto.setArmorClass(hero.getArmorClass());
        initiativeDto.setCurrentHp(hero.getCurrentHealth());
        initiativeDto.setMaxHp(hero.getMaxHealth());


        return initiativeDto;
    }
}
