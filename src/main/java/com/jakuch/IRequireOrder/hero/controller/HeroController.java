package com.jakuch.IRequireOrder.hero.controller;

import com.jakuch.IRequireOrder.hero.dto.HeroDto;
import com.jakuch.IRequireOrder.hero.model.Hero;
import com.jakuch.IRequireOrder.hero.service.HeroService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class HeroController {

    private HeroService heroService;

    @ModelAttribute("heroes")
    public List<Hero> findAll() {
        return heroService.findAll();
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
        heroService.saveHero(heroDto);
        return "redirect:/heroes";
    }

    @RequestMapping(value = "/heroes", params = {"removeById"})
    public String deleteById(@RequestParam String id) {
        heroService.deleteHero(id);
        return "redirect:/heroes";
    }

    @RequestMapping(value = "/heroes", params = {"removeAll"})
    public String deleteAll() {
        heroService.deleteAll();
        return "redirect:/heroes";
    }
}
