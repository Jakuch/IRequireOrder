package com.jakuch.IRequireOrder.srd.spells.controller;

import com.jakuch.IRequireOrder.srd.spells.service.SpellsFetcherService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SpellsController {

    private SpellsFetcherService spellsFetcherService;

    @GetMapping("/spells")
    public List<Object> fetchSpells() {
        return spellsFetcherService.fetchAllData().stream().map(it -> it.get("name")).collect(Collectors.toList());
    }

//    @GetMapping("/spells/test")
//    public String fetchSingleSpell() {
//        return spellsFetcherService.fetchSingleRecordByKey("a5e-ag_accelerando").toString();  TODO fetching single spells
//    }
}
