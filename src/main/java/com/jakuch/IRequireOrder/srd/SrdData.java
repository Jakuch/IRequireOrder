package com.jakuch.IRequireOrder.srd;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public abstract class SrdData {
    @Id
    protected String id;
    protected String name;
    protected String srdKey;
}
