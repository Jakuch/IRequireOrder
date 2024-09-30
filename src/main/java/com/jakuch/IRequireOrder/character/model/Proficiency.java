package com.jakuch.IRequireOrder.character.model;

public enum Proficiency {
    NONE,
    HALF,
    FULL,
    EXPERTISE;

    public static int calculateProficiencyBonus(Proficiency type, Level level) {
        return switch (type) {
            case NONE -> 0;
            case HALF -> level.getProficiencyBonus() / 2;
            case FULL -> level.getProficiencyBonus();
            case EXPERTISE -> level.getProficiencyBonus() * 2;
        };
    }
}
