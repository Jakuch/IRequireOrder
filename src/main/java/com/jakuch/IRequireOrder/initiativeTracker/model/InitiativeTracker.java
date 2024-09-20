package com.jakuch.IRequireOrder.initiativeTracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Data
public class InitiativeTracker {
    @Id
    private String id;
    private List<Initiative> initiative = new ArrayList<>();
}
