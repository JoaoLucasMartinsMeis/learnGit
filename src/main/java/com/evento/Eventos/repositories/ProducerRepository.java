package com.evento.Eventos.repositories;

import com.evento.Eventos.models.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {
    Optional<Producer> findByName(String name);
    Optional<Producer> findByCpfCnpj(String cpfCnpj);
}
