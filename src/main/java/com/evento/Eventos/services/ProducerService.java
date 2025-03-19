package com.evento.Eventos.services;

import com.evento.Eventos.dtos.ProducerDTO;
import com.evento.Eventos.models.Producer;
import com.evento.Eventos.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class ProducerService {

    @Autowired
    private ProducerRepository producerRepository;

    public ProducerDTO saveProducer(ProducerDTO producerDTO) {
        Producer producer = convertProducerDTOToProducer(producerDTO);
        producer = producerRepository.save(producer);
        return convertProducerToProducerDTO(producer);
    }

    public Producer getProducerById(Long id) {
        return producerRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producer not found"));
    }

    public ProducerDTO getProducerByName(String nome) {
        return convertProducerToProducerDTO(producerRepository.findByNome(nome)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producer not found")));
    }

    public ProducerDTO getProducerByCpfCnpj(String cpfCnpj) {
        return convertProducerToProducerDTO(producerRepository.findByCpfCnpj(cpfCnpj)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producer not found")));
    }

    public ProducerDTO updateProducer(ProducerDTO producerDTO) {
        if (isNull(producerDTO.getId())) {
            throw new IllegalArgumentException("Id can't be null");
        }
        Producer producer = producerRepository.findById(producerDTO.getId())
                .orElseThrow(() ->
                        new IllegalArgumentException("Producer not found"));
        producer = convertProducerDTOToProducer(producerDTO);
        producer = producerRepository.save(producer);
        return convertProducerToProducerDTO(producer);
    }

    public void deleteProducer(Long id) {
        producerRepository.deleteById(id);
    }

    public Producer convertProducerDTOToProducer(ProducerDTO producerDTO) {
        Producer producer = new Producer();
        producer.setId(producerDTO.getId());
        producer.setNome(producerDTO.getNome());
        producer.setCpfCnpj(producerDTO.getCpfCnpj());
        return producer;
    }

    public ProducerDTO convertProducerToProducerDTO(Producer producer) {
        ProducerDTO producerDTO = new ProducerDTO();
        producerDTO.setId(producer.getId());
        producerDTO.setNome(producer.getNome());
        producerDTO.setCpfCnpj(producer.getCpfCnpj());
        return producerDTO;
    }
}
