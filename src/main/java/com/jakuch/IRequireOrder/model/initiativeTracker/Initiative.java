package com.jakuch.IRequireOrder.model.initiativeTracker;

import lombok.Data;

@Data
public class Initiative {

    private int value;
    private String heroId;
    private String notes;
    //TODO perhaps add timer for each player + movement (max+current)

}
