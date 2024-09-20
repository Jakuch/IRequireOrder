package com.jakuch.IRequireOrder.initiativeTracker.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class InitiativeTrackerDto {

    private List<InitiativeDto> initiativeList = new ArrayList<>();
}
