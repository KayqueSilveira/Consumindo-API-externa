package br.com.api.FullCycle.controller;

import br.com.api.FullCycle.domains.request.HotelRequest;
import br.com.api.FullCycle.domains.response.HotelResponse;
import br.com.api.FullCycle.domains.Price;
import br.com.api.FullCycle.domains.Room;
import br.com.api.FullCycle.feign.HotelAPI;
import br.com.api.FullCycle.service.HotelService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@SpringBootTest
public class HotelControllerTeste {

    @Mock
    private HotelAPI hotelAPI;

    @InjectMocks
    private HotelService hotelService;

    private List<HotelRequest> hotelRequestList = builderHotelRequest();

    @BeforeEach
    public void execute(){
        MockitoAnnotations.openMocks(this);
        builderHotelRequest();
        builderRoom();
        builderPrice();
    }


    @Test
    public void testandoRetornoHoteis(){
        when(hotelAPI.getHotels(anyLong())).thenReturn(hotelRequestList);

        List<HotelResponse> hotelResponse = hotelService.calculaValor(anyLong());

        Assertions.assertEquals(hotelResponse.get(0).getCidade(), hotelRequestList.get(0).getCityName());
    }

    public List<HotelRequest> builderHotelRequest(){
        var x = HotelRequest.builder()
                .id(4L)
                .name("Hotel Teste 4")
                .cityCode(1032)
                .cityName("Porto Seguro")
                .rooms(builderRoom())
                .build();
        List<HotelRequest> hotelRequests = new ArrayList<>();
        hotelRequests.add(x);
        return hotelRequests;
    }

    public List<Room> builderRoom(){
        var room1 = Room.builder()
                .roomId(1L)
                .categoryName("Standard")
                .price(builderPrice())
                .build();
        var room2 = Room.builder()
                .roomId(1L)
                .categoryName("Standard")
                .price(builderPrice())
                .build();

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(room2);
        return rooms;
    }

    public Price builderPrice(){
        return Price.builder()
                .adult(341.76)
                .child(782.14)
                .build();
    }
}
