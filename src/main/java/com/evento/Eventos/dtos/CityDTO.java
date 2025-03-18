package com.evento.Eventos.dtos;
import com.evento.Eventos.enums.States;

public class CityDTO {

    private Long id;
    private String name;
    private String state;

    public CityDTO() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public States getState() {
        return States.valueOf(state);
    }
    public void setState(States state) {
        this.state = state.name();
    }
}
