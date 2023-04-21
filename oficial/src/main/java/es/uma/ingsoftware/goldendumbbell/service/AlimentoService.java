package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Alimento;
import es.uma.ingsoftware.goldendumbbell.repository.AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlimentoService {

    @Autowired
    AlimentoRepository alimentoRepository;

    public List<Alimento> getAll() {
        return alimentoRepository.findAll();
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
