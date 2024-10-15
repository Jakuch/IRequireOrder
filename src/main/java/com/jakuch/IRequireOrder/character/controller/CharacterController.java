package com.jakuch.IRequireOrder.character.controller;

import com.jakuch.IRequireOrder.character.form.CharacterForm;
import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.level.model.Level;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import com.jakuch.IRequireOrder.character.service.CharacterService;
import com.jakuch.IRequireOrder.srd.characterClass.model.CharacterClass;
import com.jakuch.IRequireOrder.srd.characterClass.service.CharacterClassFetcherService;
import com.jakuch.IRequireOrder.srd.races.model.Race;
import com.jakuch.IRequireOrder.srd.races.service.RaceFetcherService;
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

    @ModelAttribute("characters")
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @ModelAttribute("attributeNames")
    public List<AttributeName> attributes() {
        return AttributeName.correctValues();
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
