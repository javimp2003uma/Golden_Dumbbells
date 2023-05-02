package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.model.Clase;
import es.uma.ingsoftware.goldendumbbell.repository.CarritoRepository;
import es.uma.ingsoftware.goldendumbbell.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    public List<Carrito> getAll() { return carritoRepository.findAll();
    }

    public void save(Carrito e) {
        carritoRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        carritoRepository.deleteById(id);
    }

    public Carrito getById(Integer id) {
        return carritoRepository.getOne(id);
    }
}
