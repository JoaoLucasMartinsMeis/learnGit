package com.evento.Eventos.models;

import com.evento.Eventos.enums.Classification;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private String description;

    @Column(name = "start_hour")
    private String startHour;

    @Column(name = "end_hour")
    private String endHour;

    @Column(name = "opening_time")
    private String openingTime;

    private String imagem;

    @Enumerated(EnumType.STRING)
    private Classification classification;

    @ManyToOne
    private Producer producer;

    public Event() {
    }

    public Event(Long id, Date date, String description, String startHour, String endHour, String openingTime, String imagem, Classification classification, Producer producer) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id) && Objects.equals(date, event.date) && Objects.equals(description, event.description) && Objects.equals(startHour, event.startHour) && Objects.equals(endHour, event.endHour) && Objects.equals(openingTime, event.openingTime) && Objects.equals(imagem, event.imagem) && classification == event.classification && Objects.equals(producer, event.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, description, startHour, endHour, openingTime, imagem, classification, producer);
    }
}