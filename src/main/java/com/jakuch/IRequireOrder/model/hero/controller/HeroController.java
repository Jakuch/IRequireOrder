package com.jakuch.IRequireOrder.model.hero.controller;

import com.jakuch.IRequireOrder.model.hero.Hero;
import com.jakuch.IRequireOrder.model.hero.dto.HeroDto;
import com.jakuch.IRequireOrder.model.hero.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class HeroController {

    private final HeroRepository heroRepository;

    @ModelAttribute("heroes")
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @GetMapping("/heroes")
    public String heroes() {
        return "heroes";
    }

    @GetMapping("/heroAdd")
    public ModelAndView addHeroForm() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("heroDto", new HeroDto());
        modelAndView.setViewName("heroAdd");
        return modelAndView;
    }

    @PostMapping("/heroAdd")
    public String addHero(@ModelAttribute("heroDto") HeroDto heroDto) {
        heroRepository.save(heroDto.toHero());
        return "redirect:/heroes";
    }

    @RequestMapping(value = "/heroes", params = {"removeById"})
    public String deleteById(@RequestParam String id) {
        heroRepository.deleteById(id);
        return "redirect:/heroes";
    }

    @RequestMapping(value = "/heroes", params = {"removeAll"})
    public String deleteAll() {
        heroRepository.deleteAll();
        return "redirect:/heroes";
    }
}
