package com.jakuch.IRequireOrder.srd.characterClass.model;

import com.jakuch.IRequireOrder.srd.SrdData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterClass extends SrdData {

    private int level;
    private String subclassSrdKey;

    public CharacterClass(String name, String srdKey) {
        this.name = name;
        this.srdKey = srdKey;
        this.level = 1;
    }
}
