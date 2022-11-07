package br.com.api.FullCycle.domains.request;

import br.com.api.FullCycle.domains.Room;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HotelRequest {

    private Long id;
    private String name;
    private int cityCode;
    private String cityName;
    private List<Room> rooms;

}
