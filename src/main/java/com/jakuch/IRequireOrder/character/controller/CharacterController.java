package com.jakuch.IRequireOrder.character.controller;

import com.jakuch.IRequireOrder.character.dto.CharacterDto;
import com.jakuch.IRequireOrder.character.model.Character;
import com.jakuch.IRequireOrder.character.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@AllArgsConstructor
public class CharacterController {

    private CharacterService characterService;

    @ModelAttribute("characters")
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @GetMapping("/characters")
    public String characters() {
        return "characters";
    }

    @GetMapping("/characterSheet")
    public String characterSheet() {
        return "characterSheet";
    } //TODO should return model with data

    @GetMapping("/characterAdd")
    public ModelAndView addCharacterForm() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("character", new CharacterDto());
        modelAndView.setViewName("characterAdd");
        return modelAndView;
    }

    @PostMapping("/characterAdd")
    public String addCharacter(@ModelAttribute("character") CharacterDto characterDto) {
        characterService.saveCharacter(characterDto);
        return "redirect:/characters";
    }

    @RequestMapping(value = "/characters", params = {"remove"})
    public String deleteById(@RequestParam String id) {
        characterService.deleteCharacter(id);
        return "redirect:/characters";
    }

    @RequestMapping(value = "/characters", params = {"removeAll"})
    public String deleteAll() {
        characterService.deleteAll();
        return "redirect:/characters";
    }

    @RequestMapping(value = "/characters/deleteAll")
    public String deleteEndpoint() {
        characterService.deleteAll();
        return "redirect:/characters";
    }
}
