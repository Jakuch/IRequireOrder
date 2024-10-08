package com.jakuch.IRequireOrder.srd;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class SrdData {
    @Id
    protected String id;
    protected String name;
    protected String srdKey;

    public SrdData() {
    }

    public SrdData(String name, String srdKey) {
        this.name = name;
        this.srdKey = srdKey;
    }
}
