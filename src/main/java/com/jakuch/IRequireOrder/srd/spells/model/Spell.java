package com.jakuch.IRequireOrder.srd.spells.model;

import com.jakuch.IRequireOrder.srd.SrdData;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Spell extends SrdData {
    public Spell(String name, String srdKey) {
        super(name, srdKey);
    }
}
