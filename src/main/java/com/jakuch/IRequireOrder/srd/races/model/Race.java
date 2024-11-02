package com.jakuch.IRequireOrder.srd.races.model;

import com.jakuch.IRequireOrder.srd.SrdData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Race extends SrdData {
    public Race(String name, String srdKey) {
        this.name = name;
        this.srdKey = srdKey;
    }
}
