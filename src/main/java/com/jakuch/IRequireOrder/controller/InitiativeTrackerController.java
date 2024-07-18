package com.jakuch.IRequireOrder.controller;

import com.jakuch.IRequireOrder.model.initiativeTracker.InitiativeTracker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InitiativeTrackerController {

    @GetMapping("/initiativeTracker")
    public ModelAndView get() {
        var modelAndView = new ModelAndView();
        modelAndView.addObject("tracker", new InitiativeTracker());
        modelAndView.setViewName("initiativeTracker");
        return modelAndView;
    }


}
