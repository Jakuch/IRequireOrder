package com.jakuch.IRequireOrder.srd.races.model;

import com.jakuch.IRequireOrder.srd.SrdData;
import lombok.Data;

@Data
public class Race extends SrdData {
    public Race(String name, String srdKey) {
        super(name, srdKey);
    }
}
