package org.acme.Service;

import org.acme.Entity.Wine;
import org.acme.Repository.WineRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class WineService {

    @Inject
    WineRepository wineRepository;

    @Transactional
    public void addWine(Wine wine) {
        wineRepository.addWine(wine);
    }
}
