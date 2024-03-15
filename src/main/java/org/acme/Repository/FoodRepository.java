package org.acme.Repository;

import java.util.List;

import org.acme.Entity.Food;


import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class FoodRepository implements PanacheRepository<Food> {

    @Inject
    EntityManager entityManager;

    public Food findbyId(long id){

        return entityManager.find(Food.class, id);
    }
    
    public List<Food> findAllFoods(){

        return listAll();
    }

     @Transactional
    public void addFood (Food food){

        persist(food);
    } 
}