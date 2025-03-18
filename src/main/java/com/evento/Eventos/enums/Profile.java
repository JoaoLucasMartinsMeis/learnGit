package com.evento.Eventos.enums;

public enum Profile {
    ADMINISTRATOR("Administrator", "Adm"),
    MANAGER("Maneger", "Ger"),
    USER("User", "Usr");

    private final String acronym;

    private final String description;

    Profile(String description, String acronym) {
        this.description = description;
        this.acronym = acronym;
    }

    public String getDescription() {
        return description;
    }

    public String getAcronym() {
        return acronym;
    }
}
