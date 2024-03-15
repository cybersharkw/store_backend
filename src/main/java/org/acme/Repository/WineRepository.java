package org.acme.Repository;

import java.util.List;

import org.acme.Entity.Wine;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class WineRepository implements PanacheRepository<Wine> {
    
    @Inject
    EntityManager entityManager;

    public Wine findById (long id)  {
        return entityManager.find(Wine.class, id);
    }

    public List <Wine> findAllWines(){
        return listAll();
    }

    @Transactional
    public void addWine( Wine wine){

        persist(wine);
    }


}
