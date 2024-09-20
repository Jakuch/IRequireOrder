package com.jakuch.IRequireOrder.hero.model.savingThrows;

import com.jakuch.IRequireOrder.hero.model.attributes.AttributeName;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SavingThrowInitializer {

    public static List<SavingThrow> initializeSavingThrows() {
        return Arrays.stream(AttributeName.values())
                .map(attributeName -> new SavingThrow(attributeName.name()))
                .collect(Collectors.toList());
    }
}
