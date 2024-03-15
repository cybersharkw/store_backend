package org.acme.Repository;

import java.util.List;

import org.acme.Entity.Producer;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ProducerRepository implements PanacheRepository<Producer> {

    @Inject
    EntityManager entityManager;

    public Producer findbyId(long id){

        return entityManager.find(Producer.class, id);
    }
    
    public List<Producer> findAllProducers(){

        return listAll();
    }

   @Transactional
    public void addProducer( Producer producer){

        persist(producer);
    } 
}
