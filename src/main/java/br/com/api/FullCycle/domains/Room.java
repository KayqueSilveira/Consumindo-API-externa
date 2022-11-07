package br.com.api.FullCycle.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Room {

    private Long roomId;
    private String categoryName;
    private Price price;
}
