package com.jakuch.IRequireOrder.hero.model.skills;

import com.jakuch.IRequireOrder.hero.model.Advantage;
import com.jakuch.IRequireOrder.hero.model.Proficiency;
import com.jakuch.IRequireOrder.hero.model.attributes.AttributeName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Skill {
    private String name;
    private int value;
    private Proficiency proficiency;
    private Advantage advantage;
    private AttributeName modifier;

    public Skill(String name) {
        this.name = name;
    }
}
