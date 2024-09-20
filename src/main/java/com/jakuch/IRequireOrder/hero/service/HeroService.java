package com.jakuch.IRequireOrder.hero.service;

import com.jakuch.IRequireOrder.hero.dto.HeroDto;
import com.jakuch.IRequireOrder.hero.model.Hero;
import com.jakuch.IRequireOrder.hero.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroService {

    private HeroRepository heroRepository;

    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    public String saveHero(HeroDto heroDto) {
        return heroRepository.save(heroDto.toHero()).getId();
    }

    public void deleteHero(String id) {
        heroRepository.deleteById(id);
    }

    public void deleteAll() {
        heroRepository.deleteAll();
    }
}
