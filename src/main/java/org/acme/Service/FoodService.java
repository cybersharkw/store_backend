package org.acme.Service;

import org.acme.Entity.Food;

import org.acme.Repository.FoodRepository;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
@ApplicationScoped
public class FoodService {
    
    
    @Inject
    FoodRepository foodRepository;

    @Transactional
    public void addFoods(Food food) {
        foodRepository.addFood(food);
    }
}
