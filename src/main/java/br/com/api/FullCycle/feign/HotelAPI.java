package br.com.api.FullCycle.feign;

import br.com.api.FullCycle.domains.request.HotelRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "hotel", url = "https://cvcbackendhotel.herokuapp.com/hotels/avail/")
public interface HotelAPI {

    @RequestMapping("{idHotel}")
    public List<HotelRequest> getHotels(@PathVariable Long idHotel);
}
