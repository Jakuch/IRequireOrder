package com.jakuch.IRequireOrder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitiativeTrackerController {

    @GetMapping("/initiativeTracker")
    public ModelAndView get() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("initiativeTracker");
        return modelAndView;
    }

}
