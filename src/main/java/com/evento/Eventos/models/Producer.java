package com.evento.Eventos.models;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cpf_cnpj", unique = true)
    private String cpfCnpj;

    public Producer() {}

    public Producer(Long id, String name, String cpfCnpj) {
        this.id = id;
        this.name = name;
        this.cpfCnpj = cpfCnpj;
    }

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

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producer produtora = (Producer) o;
        return Objects.equals(id, produtora.id) && Objects.equals(name, produtora.name) && Objects.equals(cpfCnpj, produtora.cpfCnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cpfCnpj);
    }
}

