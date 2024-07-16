package com.jakuch.IRequireOrder.controller;

import com.jakuch.IRequireOrder.model.Attributes;
import com.jakuch.IRequireOrder.model.Hero;
import com.jakuch.IRequireOrder.repository.HeroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Controller {

    private final HeroRepository heroRepository;

    public Controller(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @ModelAttribute("heroes")
    @GetMapping("/all")
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }


    @ModelAttribute("removed")
    @GetMapping("/deleteAll")
    public boolean removeAll() {
        heroRepository.deleteAll();
        return true;
    }

    @ModelAttribute("id")
    @GetMapping("/add")
    public String add() {
        Hero hero = new Hero();
        hero.setName("Hero1");
        hero.setAttributes(new Attributes());
        return heroRepository.save(hero).getId();
    }
}
