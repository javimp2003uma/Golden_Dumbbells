package es.uma.ingsoftware.goldendumbbell.service;
import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getAll() {
        return productoRepository.findAll();
    }

    public void save(Producto e) {
        productoRepository.saveAndFlush(e);
    }

    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    public Producto getById(Integer id) {
        return productoRepository.getOne(id);
    }
}
