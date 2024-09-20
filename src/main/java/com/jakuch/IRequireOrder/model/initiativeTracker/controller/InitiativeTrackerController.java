package com.jakuch.IRequireOrder.model.initiativeTracker.controller;

import com.jakuch.IRequireOrder.model.hero.repository.HeroRepository;
import com.jakuch.IRequireOrder.model.initiativeTracker.InitiativeTracker;
import com.jakuch.IRequireOrder.model.initiativeTracker.dto.InitiativeDto;
import com.jakuch.IRequireOrder.model.initiativeTracker.dto.InitiativeTrackerDto;
import com.jakuch.IRequireOrder.model.initiativeTracker.repository.InitiativeTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.Comparator;

@Controller
@AllArgsConstructor
public class InitiativeTrackerController {

    //TODO move all the logic to some kind of service same with heroes
    private InitiativeTrackerRepository initiativeTrackerRepository;
    private HeroRepository heroRepository;

    @RequestMapping("/initiativeTracker")
    public ModelAndView get(InitiativeTrackerDto initiativeTrackerDto, ModelAndView modelAndView) {
        modelAndView.addObject("initiativeTracker", initiativeTrackerDto);
        modelAndView.setViewName("initiativeTracker");
        return modelAndView;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"saveTracker"})
    public Model saveTracker(@ModelAttribute("initiativeTracker") InitiativeTrackerDto initiativeTrackerDto, Model model) {
        var initiativeTracker = new InitiativeTracker();
        initiativeTrackerDto.getInitiativeList()
                .forEach(el -> {
                    var id = heroRepository.save(el.toHero()).getId();
                    var initiative = el.toInitiative(id);

                    initiativeTracker.getInitiative().add(initiative);
                });
        var savedInitiativeTracker = initiativeTrackerRepository.save(initiativeTracker);

        model.addAttribute("initiativeId", savedInitiativeTracker.getId());
        return model;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"loadTracker"})
    public Model loadTracker(@RequestParam(value = "id") String id, Model model) throws FileNotFoundException {
        var results = initiativeTrackerRepository.findById(id);
        if (results.isPresent()) {
            var initiativeTrackerDto = new InitiativeTrackerDto();
            var initiativeTracker = results.get();
            initiativeTracker.getInitiative().forEach(el ->
            {
                var optionalHero = heroRepository.findById(el.getHeroId());
                if (optionalHero.isPresent()) {
                    var initiativeDto = InitiativeDto.toDto(el, optionalHero.get());
                    initiativeTrackerDto.getInitiativeList().add(initiativeDto);
                }
            });
            model.addAttribute("initiativeTracker", initiativeTrackerDto);
            return model;
        } else {
            throw new FileNotFoundException("Error there is no such tracker");
        }
    }

    @RequestMapping(value = "/initiativeTracker", params = {"addRow"})
    public Model addRow(InitiativeTrackerDto initiativeTrackerDto, Model model) {
        initiativeTrackerDto.getInitiativeList().add(new InitiativeDto());
        model.addAttribute("initiativeTracker", initiativeTrackerDto);
        return model;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"sort"})
    public Model sortInitiative(InitiativeTrackerDto initiativeTrackerDto, Model model) {
        initiativeTrackerDto.getInitiativeList().sort(Comparator.comparing(InitiativeDto::getValue).reversed());
        model.addAttribute("initiativeTracker", initiativeTrackerDto);
        return model;
    }

    @GetMapping("/removeAllInitiatives")
    public String removeAll() {
        initiativeTrackerRepository.deleteAll();
        return "redirect:/home";
    }

}
