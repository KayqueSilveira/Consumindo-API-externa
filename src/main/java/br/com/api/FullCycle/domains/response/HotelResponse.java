package br.com.api.FullCycle.domains.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelResponse {

    private String hotel;
    private String cidade;
    private double valorTotal;
}
