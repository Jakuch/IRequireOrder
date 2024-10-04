package com.jakuch.IRequireOrder.character.controller;

import com.jakuch.IRequireOrder.character.form.CharacterForm;
import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.level.model.Level;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.character.service.CharacterService;
import com.jakuch.IRequireOrder.srd.characterClass.model.CharacterClass;
import com.jakuch.IRequireOrder.srd.characterClass.service.CharacterClassFetcherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class CharacterController {

    private CharacterService characterService;
    private CharacterClassFetcherService characterClassFetcherService;

    @ModelAttribute("characters")
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @ModelAttribute("attributeNames")
    public List<AttributeName> attributes() {
        return AttributeName.correctValues();
    }

    @ModelAttribute("levels")
    public List<Level> levels() {
        return Arrays.asList(Level.values());
    }

    @ModelAttribute("classes")
    public List<CharacterClass> classes() {
        return characterClassFetcherService.fetchMappedCharacterClassList();
    }

    @GetMapping("/characters")
    public String characters() {
        return "characters";
    }

    @RequestMapping(value = "/characters", params = {"characterSheet"})
    public ModelAndView characterSheet(@RequestParam String id) {
        var character = characterService.findById(id);
        var modelAndView = new ModelAndView();
        modelAndView.addObject("character", character);
        modelAndView.setViewName("characterSheet");
        return modelAndView;
    }

    @GetMapping("/characterAdd")
    public ModelAndView addCharacterForm() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("character", new CharacterForm());
        modelAndView.setViewName("characterAdd");
        return modelAndView;
    }

    @PostMapping("/characterAdd")
    public String addCharacter(@ModelAttribute("character") CharacterForm characterForm) {
        characterService.saveCharacter(characterForm);
        return "redirect:/characters";
    }

    @RequestMapping(value = "/characters", params = {"delete"})
    public String deleteById(@RequestParam String id) {
        characterService.deleteCharacter(id);
        return "redirect:/characters";
    }

    @RequestMapping(value = "/characters/deleteAll")
    public String deleteAll() {
        characterService.deleteAll();
        return "redirect:/characters";
    }
}
