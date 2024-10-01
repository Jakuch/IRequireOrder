package com.jakuch.IRequireOrder.initiativeTracker.service;

import com.jakuch.IRequireOrder.character.repository.CharacterRepository;
import com.jakuch.IRequireOrder.initiativeTracker.dto.InitiativeDto;
import com.jakuch.IRequireOrder.initiativeTracker.dto.InitiativeTrackerDto;
import com.jakuch.IRequireOrder.initiativeTracker.model.InitiativeTracker;
import com.jakuch.IRequireOrder.initiativeTracker.repository.InitiativeTrackerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
@AllArgsConstructor
public class InitiativeService {

    private InitiativeTrackerRepository initiativeTrackerRepository;
    private CharacterRepository characterRepository;

    public String saveInitiativeTracker(InitiativeTrackerDto initiativeTrackerDto) {
        var initiativeTracker = new InitiativeTracker();
        initiativeTrackerDto.getInitiativeList()
                .forEach(el -> {
                    var id = characterRepository.save(el.toCharacter()).getId();
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
                var optionalCharacter = characterRepository.findById(el.getCharacterId());
                if (optionalCharacter.isPresent()) {
                    var initiativeDto = InitiativeDto.toDto(el, optionalCharacter.get());
                    initiativeTrackerDto.getInitiativeList().add(initiativeDto);
                }
            });
            return initiativeTrackerDto;
        } else {
            throw new FileNotFoundException("Error there is no such tracker");
        }
    }

    public void deleteAll() {
        initiativeTrackerRepository.deleteAll();
    }
}
