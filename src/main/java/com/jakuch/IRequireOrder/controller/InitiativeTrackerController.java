package com.jakuch.IRequireOrder.controller;

import com.jakuch.IRequireOrder.model.initiativeTracker.InitiativeTracker;
import com.jakuch.IRequireOrder.repository.HeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class InitiativeTrackerController {

    private HeroRepository heroRepository;

    @GetMapping("/initiativeTracker")
    public ModelAndView get() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("tracker", new InitiativeTracker());
        modelAndView.setViewName("initiativeTracker");
        return modelAndView;
    }

    @PostMapping
    public void addHeroToTracker() {
        //TODO not implemented
    }

}
