package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;

    public List<Alimento> getAll() {
        return alimentoRepository.findAll();
    }

    public List<String> getAllNombres () {
        List<Alimento> aux = alimentoRepository.findAll();
        List<String> nombres = new ArrayList<>();
        for (Alimento a : aux) {
            nombres.add(a.getName());
        }
        return nombres;
    }

    public void save(Alimento e) {
        alimentoRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        alimentoRepository.deleteById(id);
    }

    public Alimento getById(Integer id) {
        return alimentoRepository.getOne(id);
    }

}
