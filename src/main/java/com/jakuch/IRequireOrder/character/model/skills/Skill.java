package com.jakuch.IRequireOrder.character.model.skills;

import com.jakuch.IRequireOrder.character.model.Advantage;
import com.jakuch.IRequireOrder.character.model.Proficiency;
import com.jakuch.IRequireOrder.character.model.attributes.AttributeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private String name;
    private int value;
    private Proficiency proficiency;
    private Advantage advantage;
    private AttributeName modifier;

    public Skill(String name) {
        this.name = name;
        this.value = 0;
        this.proficiency = Proficiency.NONE;
        this.advantage = Advantage.NONE;
        this.modifier = AttributeName.findByName(trimNameIfNeeded(name));
    }

    private String trimNameIfNeeded(String name) {
        int index = name.indexOf(" ");
        if (index != -1) {
            return name.substring(0, index);
        }
        return name;
    }
}
