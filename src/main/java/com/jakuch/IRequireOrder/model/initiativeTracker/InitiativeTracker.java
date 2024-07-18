package com.jakuch.IRequireOrder.model.initiativeTracker;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class InitiativeTracker {
    @Id
    private String id;
    private String name;
    private List<Initiative> initiative;
}
