package br.com.api.FullCycle.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private double adult;
    private double child;
}
