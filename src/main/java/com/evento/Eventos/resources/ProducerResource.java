package com.evento.Eventos.resources;

import com.evento.Eventos.dtos.ProducerDTO;
import com.evento.Eventos.models.Producer;
import com.evento.Eventos.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producer")
public class ProducerResource {

    @Autowired
    private ProducerService producerService;

    @GetMapping("{id}")
    public ResponseEntity<ProducerDTO> getProducerbyId(@PathVariable Long id) {
        Producer producer = producerService.getProducerById(id);
        return ResponseEntity.ok(producerService.convertProducerToProducerDTO(producer));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProducerDTO>> getProducerByName(@RequestParam String name) {
        ProducerDTO producerDTO = producerService.getProducerByName(name);
        return ResponseEntity.ok(List.of(producerDTO));
    }

    @PostMapping("")
    public ResponseEntity<ProducerDTO> createProducer(@RequestBody ProducerDTO producerDTO) {
        return ResponseEntity.ok(producerService.saveProducer(producerDTO));
    }

    @PutMapping()
    public ResponseEntity<ProducerDTO> updateProducer(@RequestBody ProducerDTO producerDTO) {
        return ResponseEntity.ok(producerService.updateProducer(producerDTO));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteProducer(@PathVariable ProducerDTO producerDTO) {
        producerService.deleteProducer(producerDTO.getId());
        return ResponseEntity.noContent().build();
    }
}
