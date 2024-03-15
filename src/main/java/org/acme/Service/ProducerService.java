package org.acme.Service;

import org.acme.Entity.Producer;
import org.acme.Repository.ProducerRepository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProducerService {

    @Inject
    ProducerRepository producerRepository;

    @Transactional
    public void addProducers(Producer producer) {
        producerRepository.addProducer(producer);
    }
}
