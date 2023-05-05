package es.uma.ingsoftware.goldendumbbell.service;


import es.uma.ingsoftware.goldendumbbell.model.Carrito;
import es.uma.ingsoftware.goldendumbbell.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    CarritoRepository carritoRepository;

    public List<Carrito> getAll() {
        return carritoRepository.findAll();
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
