package com.jakuch.IRequireOrder.character.controller;

import com.jakuch.IRequireOrder.character.form.CharacterForm;
import com.jakuch.IRequireOrder.character.service.CharacterService;
import com.jakuch.IRequireOrder.level.model.Level;
import com.jakuch.IRequireOrder.srd.characterClass.model.CharacterClass;
import com.jakuch.IRequireOrder.srd.characterClass.service.CharacterClassFetcherService;
import com.jakuch.IRequireOrder.srd.races.model.Race;
import com.jakuch.IRequireOrder.srd.races.service.RaceFetcherService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@AllArgsConstructor
public class CharacterAddController {

    private CharacterService characterService;
    private CharacterClassFetcherService characterClassFetcherService;
    private RaceFetcherService raceFetcherService;

    @ModelAttribute("levels")
    public List<Level> levels() {
        return Arrays.asList(Level.values());
    }

    @ModelAttribute("classes")
    public List<CharacterClass> classes() {
        return characterClassFetcherService.fetchAllMappedData();
    }

    @ModelAttribute("races")
    public List<Race> races() { return raceFetcherService.fetchAllMappedData(); }

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
}
