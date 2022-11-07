package br.com.api.FullCycle.service;

import br.com.api.FullCycle.domains.response.HotelResponse;
import br.com.api.FullCycle.domains.Price;
import br.com.api.FullCycle.feign.HotelAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {


    @Autowired
    private HotelAPI hotelAPI;

    public List<HotelResponse> calculaValor(final Long id){
        var hotels = hotelAPI.getHotels(id);
        List<HotelResponse> responseList = new ArrayList<>();

        for(int hotel = 0; hotel<hotels.size(); hotel++){
            HotelResponse hotelResponse = new HotelResponse();
            double valorTotal = 0;
            for(int room=0; room<hotels.get(hotel).getRooms().size(); room++) {
                Price price = hotels.get(hotel).getRooms().get(room).getPrice();
                valorTotal += (price.getAdult() * 2) + price.getChild();
            }

            hotelResponse.setHotel(hotels.get(hotel).getName());
            hotelResponse.setCidade(hotels.get(hotel).getCityName());
            hotelResponse.setValorTotal(valorTotal);
            responseList.add(hotelResponse);

        }
        return responseList;
    }
}
