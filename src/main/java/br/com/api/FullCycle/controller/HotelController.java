package br.com.api.FullCycle.controller;

import br.com.api.FullCycle.domains.response.HotelResponse;
import br.com.api.FullCycle.service.HotelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/hoteis")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @ApiOperation(value = "Retorna uma lista de hoteis de determinada cidade")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna a lista de hoteis"),
            @ApiResponse(code = 404, message = "Código do hotel incorreto"),
            @ApiResponse(code = 500, message = "Foi gerada uma exceção"),
    })
    @GetMapping("{idHotel}")
    public List<HotelResponse> getHotels(@PathVariable Long idHotel){
        return hotelService.calculaValor(idHotel);
    }
}
