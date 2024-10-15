package com.jakuch.IRequireOrder.srd;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public abstract class SrdData {
    @Id
    protected String id;
    protected String name;
    protected String srdKey;

    public SrdData(String name, String srdKey) {
        this.name = name;
        this.srdKey = srdKey;
    }
}
