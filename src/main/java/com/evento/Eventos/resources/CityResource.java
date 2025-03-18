package com.evento.Eventos.resources;

import com.evento.Eventos.dtos.CityDTO;
import com.evento.Eventos.models.City;
import com.evento.Eventos.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityResource {

    @Autowired
    private CityService cityService;

    @GetMapping("{id}")
    public ResponseEntity<CityDTO> getCitybyId(@PathVariable Long id) {
        City city = cityService.getCityById(id);
        return ResponseEntity.ok(cityService.convertCityToCityDTO(city));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<CityDTO>> getCityByName(@RequestParam String name) {
        CityDTO cityDTO = cityService.getCityByName(name);
        return ResponseEntity.ok(List.of(cityDTO));
    }

    @PostMapping("")
    public ResponseEntity<CityDTO> createCity(@RequestBody CityDTO cityDTO) {
        return ResponseEntity.ok(cityService.saveCity(cityDTO));
    }

    @PutMapping()
    public ResponseEntity<CityDTO> updateCity(@RequestBody CityDTO cityDTO) {
        return ResponseEntity.ok(cityService.updateCity(cityDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteCity(@PathVariable CityDTO cityDTO) {
        cityService.deleteCity(cityDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
