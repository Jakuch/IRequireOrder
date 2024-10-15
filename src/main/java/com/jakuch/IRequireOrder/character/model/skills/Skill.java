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
}
