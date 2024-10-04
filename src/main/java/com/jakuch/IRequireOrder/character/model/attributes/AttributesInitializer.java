package com.jakuch.IRequireOrder.character.model.attributes;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class AttributesInitializer {

    public static Map<String, Attribute> initializeDefaultAttributes() {
        return AttributeName.correctValues().stream()
                .collect(Collectors.toMap(Enum::name, attributeName -> new Attribute(0)));
    }
}
