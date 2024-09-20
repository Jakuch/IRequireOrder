package com.jakuch.IRequireOrder.hero.service;

import com.jakuch.IRequireOrder.hero.dto.HeroDto;
import com.jakuch.IRequireOrder.hero.model.Advantage;
import com.jakuch.IRequireOrder.hero.model.Hero;
import com.jakuch.IRequireOrder.hero.model.InitiativeBonus;
import com.jakuch.IRequireOrder.hero.model.Level;
import com.jakuch.IRequireOrder.hero.model.attributes.Attribute;
import com.jakuch.IRequireOrder.hero.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.hero.model.Proficiency;
import com.jakuch.IRequireOrder.hero.model.skills.Skill;
import com.jakuch.IRequireOrder.hero.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class HeroService {

    private HeroRepository heroRepository;

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public String saveHero(HeroDto heroDto) {
        return heroRepository.save(dtoToPojo(heroDto)).getId();
    }

    public void deleteHero(String id) {
        heroRepository.deleteById(id);
    }

    public void deleteAll() {
        heroRepository.deleteAll();
    }

    private Hero dtoToPojo(HeroDto heroDto) {
        var hero = new Hero();

        hero.setLevel(Level.findByNumericValue(heroDto.getLevel()));
        hero.setAttributes(getAttributes(heroDto));

        hero.setCurrentExperiencePoints(hero.getLevel().getRequiredExperience());
        hero.setInitiativeBonus(new InitiativeBonus(hero.getAttributes().get(AttributeName.DEXTERITY).getBonus(), Advantage.NONE));
        hero.setWalkingSpeed(heroDto.getWalkingSpeed());
        hero.setName(heroDto.getName());
        hero.setMaxHealth(heroDto.getMaxHealth());
        hero.setCurrentHealth(heroDto.getCurrentHealth());
        hero.setArmorClass(heroDto.getArmorClass());

        hero.getSkills().forEach(skill -> {
            skill.setValue(calculateSkillBonus(skill, hero));
        });

        return hero;
    }

    private int calculateSkillBonus(Skill skill, Hero hero) {
        int attributeBonus = hero.getAttributes().get(skill.getModifier()).getBonus();
        int proficiencyBonus = Proficiency.calculateProficiencyBonus(skill.getProficiency(), hero.getLevel());

        return attributeBonus + proficiencyBonus;
    }

    private Map<AttributeName, Attribute> getAttributes(HeroDto heroDto) {
        var attributes = new HashMap<AttributeName, Attribute>();

        attributes.put(AttributeName.STRENGTH, new Attribute(heroDto.getStrength()));
        attributes.put(AttributeName.DEXTERITY, new Attribute(heroDto.getDexterity()));
        attributes.put(AttributeName.CONSTITUTION, new Attribute(heroDto.getConstitution()));
        attributes.put(AttributeName.INTELLIGENCE, new Attribute(heroDto.getIntelligence()));
        attributes.put(AttributeName.WISDOM, new Attribute(heroDto.getWisdom()));
        attributes.put(AttributeName.CHARISMA, new Attribute(heroDto.getCharisma()));

        return attributes;
    }
}
