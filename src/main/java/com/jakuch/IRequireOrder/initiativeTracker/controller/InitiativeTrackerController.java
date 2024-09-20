package com.jakuch.IRequireOrder.initiativeTracker.controller;

import com.jakuch.IRequireOrder.initiativeTracker.dto.InitiativeDto;
import com.jakuch.IRequireOrder.initiativeTracker.dto.InitiativeTrackerDto;
import com.jakuch.IRequireOrder.initiativeTracker.service.InitiativeService;
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

    private InitiativeService initiativeService;

    @RequestMapping("/initiativeTracker")
    public ModelAndView get(InitiativeTrackerDto initiativeTrackerDto, ModelAndView modelAndView) {
        modelAndView.addObject("initiativeTracker", initiativeTrackerDto);
        modelAndView.setViewName("initiativeTracker");
        return modelAndView;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"saveTracker"})
    public Model saveTracker(@ModelAttribute("initiativeTracker") InitiativeTrackerDto initiativeTrackerDto, Model model) {
        var initiativeId = initiativeService.saveInitiativeTracker(initiativeTrackerDto);
        model.addAttribute("initiativeId", initiativeId);
        return model;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"loadTracker"})
    public Model loadTracker(@RequestParam(value = "id") String id, Model model) throws FileNotFoundException {
        var initiativeTrackerDto = initiativeService.loadInitiativeTracker(id);
        model.addAttribute("initiativeTracker", initiativeTrackerDto);
        return model;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"addRow"})
    public Model addRow(InitiativeTrackerDto initiativeTrackerDto, Model model) {
        initiativeTrackerDto.getInitiativeList().add(new InitiativeDto());
        model.addAttribute("initiativeTracker", initiativeTrackerDto);
        return model;
    }

    @RequestMapping(value = "/initiativeTracker", params = {"sort"})
    public Model sortInitiative(InitiativeTrackerDto initiativeTrackerDto, Model model) {
        initiativeTrackerDto.getInitiativeList().sort(Comparator.comparing(InitiativeDto::getValue, Comparator.nullsLast(Integer::compareTo)).reversed());
        model.addAttribute("initiativeTracker", initiativeTrackerDto);
        return model;
    }

    @GetMapping("/initiativeTracker/removeAll")
    public String removeAll() {
        initiativeService.removeAllTrackers();
        return "redirect:/home";
    }

}
