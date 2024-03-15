package org.acme.Repository;

import java.util.List;

import org.acme.Entity.Spirit;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SpiritRepository implements PanacheRepository<Spirit> {

    @Inject
    EntityManager entityManager;

    public Spirit findById (long id){
        return entityManager.find(Spirit.class, id);
    }

    public List<Spirit> findAllSpirits(){
        return listAll();
        
    }

    
    @Transactional
    public void addSpirit( Spirit spirit){

        persist(spirit);
    }

    
}
