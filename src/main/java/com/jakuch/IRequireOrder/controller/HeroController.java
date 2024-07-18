package com.jakuch.IRequireOrder.controller;

import com.jakuch.IRequireOrder.model.hero.Hero;
import com.jakuch.IRequireOrder.model.hero.dto.HeroDto;
import com.jakuch.IRequireOrder.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class HeroController {

    private final HeroRepository heroRepository;

    @GetMapping("/heroes")
    public ModelAndView heroes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("heroes");
        return modelAndView;
    }

    @ModelAttribute("heroes")
    @GetMapping("/heroesAll")
    public List<Hero> findAll() {
        return heroRepository.findAll();
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
        return "redirect:/heroesAll";
    }

    @PostMapping("/heroDeleteById")
    public String deleteById(@RequestParam String id) {
        heroRepository.deleteById(id);
        return "redirect:/heroesAll";
    }

    @PostMapping("/heroesDeleteAll")
    public void deleteAll() {
        heroRepository.deleteAll();
    }
}
