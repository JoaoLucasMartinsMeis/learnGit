package com.evento.Eventos.enums;

public enum Classification {
    FREE("Free"),
    ABOVE_12_YEARS("Above 12 years"),
    ABOVE_18_YEARS("Above 18 years");

    private final String description;

    Classification(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
