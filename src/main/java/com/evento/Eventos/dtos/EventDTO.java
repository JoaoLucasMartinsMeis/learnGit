package com.evento.Eventos.dtos;

import com.evento.Eventos.enums.Classification;
import com.evento.Eventos.models.Producer;
import java.util.Date;

public class EventDTO {
    private Long id;
    private Date date;
    private String description;
    private String startHour;
    private String endHour;
    private String openingTime;
    private String imagem;
    private Classification classification;
    private Producer producer;

    public EventDTO() {
    }

    public EventDTO(Long id, Date date, String description, String startHour, String endHour, String openingTime, String imagem, Classification classification, Producer producer) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
        this.openingTime = openingTime;
        this.imagem = imagem;
        this.classification = classification;
        this.producer = producer;
    }
}
