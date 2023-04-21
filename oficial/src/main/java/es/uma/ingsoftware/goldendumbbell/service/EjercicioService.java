package es.uma.ingsoftware.goldendumbbell.service;
import es.uma.ingsoftware.goldendumbbell.model.Ejercicio;
import es.uma.ingsoftware.goldendumbbell.repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    EjercicioRepository ejercicioRepository;

    public List<Ejercicio> getAll() {
        return ejercicioRepository.findAll();
    }

    public void save(Ejercicio e) {
        ejercicioRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        ejercicioRepository.deleteById(id);
    }

    public Ejercicio getById(Integer id) {
        return ejercicioRepository.getOne(id);
    }
}
