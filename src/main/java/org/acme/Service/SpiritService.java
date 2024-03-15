package org.acme.Service;

import org.acme.Entity.Spirit;
import org.acme.Repository.SpiritRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class SpiritService {

    @Inject
    SpiritRepository spiritRepository;

    @Transactional
    public void addSpirits(Spirit spirit) {
        spiritRepository.addSpirit(spirit);
    }
}
