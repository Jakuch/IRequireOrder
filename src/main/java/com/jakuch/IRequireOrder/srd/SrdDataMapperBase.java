package com.jakuch.IRequireOrder.srd;

import org.bson.json.JsonObject;

public interface SrdDataMapperBase<D extends SrdData> {
    D mapToBaseSrdData(JsonObject jsonObject);
    D mapFullData(JsonObject jsonObject);
}
