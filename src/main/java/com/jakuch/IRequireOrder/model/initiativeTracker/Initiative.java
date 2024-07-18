package com.jakuch.IRequireOrder.model.initiativeTracker;

import com.jakuch.IRequireOrder.model.hero.Hero;
import lombok.Data;

@Data
public class Initiative {

    private int value;
    private Hero hero;
    private String notes;
    //TODO perhaps add timer for each player + movement (max+current)

}
