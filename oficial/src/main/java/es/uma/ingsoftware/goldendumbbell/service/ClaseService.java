package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {


    @Autowired
    ClaseRepository claseRepository;

    public List<Clase> getAll() {
        return claseRepository.findAll();
    }

    public void save(Clase e) {
        claseRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        claseRepository.deleteById(id);
    }

    public Clase getById(Integer id) {
        return claseRepository.getOne(id);
    }
}
