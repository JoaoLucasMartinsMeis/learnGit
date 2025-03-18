package com.evento.Eventos.services;

import com.evento.Eventos.dtos.CityDTO;
import com.evento.Eventos.models.City;
import com.evento.Eventos.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public CityDTO saveCity(CityDTO cityDTO) {
        City city = convertCityDTOToCity(cityDTO);
        city = cityRepository.save(city);
        return convertCityToCityDTO(city);
    }

    public CityDTO convertCityToCityDTO(City city) {
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setState(city.getState());
        return cityDTO;
    }

    public City convertCityDTOToCity(CityDTO cityDTO) {
        City city = new City();
        city.setId(cityDTO.getId());
        city.setName(cityDTO.getName());
        city.setState(cityDTO.getState());
        return city;
    }
    
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("City not found"));
    }

    public CityDTO updateCity(CityDTO cityDTO) {
        if (isNull(cityDTO.getId())) {
            throw new IllegalArgumentException("Id can't be null");
        }

        City city = cityRepository.findById(cityDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("City not found"));

        city = convertCityDTOToCity(cityDTO);
        city = cityRepository.save(city);
        return convertCityToCityDTO(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public CityDTO getCityByName(String name) {
        return convertCityToCityDTO(cityRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("City not found")));
    }
}
