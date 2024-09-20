package com.jakuch.IRequireOrder.model.initiativeTracker.service;

import com.jakuch.IRequireOrder.model.hero.repository.HeroRepository;
import com.jakuch.IRequireOrder.model.initiativeTracker.InitiativeTracker;
import com.jakuch.IRequireOrder.model.initiativeTracker.dto.InitiativeDto;
import com.jakuch.IRequireOrder.model.initiativeTracker.dto.InitiativeTrackerDto;
import com.jakuch.IRequireOrder.model.initiativeTracker.repository.InitiativeTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InitiativeService {

    private InitiativeTrackerRepository initiativeTrackerRepository;
    private HeroRepository heroRepository;

    public String saveInitiativeTracker(InitiativeTrackerDto initiativeTrackerDto) {
        var initiativeTracker = new InitiativeTracker();
        initiativeTrackerDto.getInitiativeList()
                .forEach(el -> {
                    var id = heroRepository.save(el.toHero()).getId();
                    var initiative = el.toInitiative(id);

                    initiativeTracker.getInitiative().add(initiative);
                });
        return initiativeTrackerRepository.save(initiativeTracker).getId();
    }

    public InitiativeTrackerDto loadInitiativeTracker(String id) throws FileNotFoundException {
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
            return initiativeTrackerDto;
        } else {
            throw new FileNotFoundException("Error there is no such tracker");
        }
    }

    public void removeAllTrackers() {
        initiativeTrackerRepository.deleteAll();
    }
}
