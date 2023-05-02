package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Frase;
import es.uma.ingsoftware.goldendumbbell.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FraseService {

    @Autowired
    FraseRepository fraseRepository;

    public List<Frase> getAll() {
        return fraseRepository.findAll();
    }
}
