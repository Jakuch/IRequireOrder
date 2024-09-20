package com.jakuch.IRequireOrder.hero.model.attributes;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AttributesInitializer {

    public static Map<AttributeName, Attribute> initializeDefaultAttributes() {
        return Arrays.stream(AttributeName.values())
                .collect(Collectors.toMap(attributeName -> attributeName, attributeName -> new Attribute(0)));
    }
}
