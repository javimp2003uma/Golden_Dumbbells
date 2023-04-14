package es.uma.ingsoftware.goldendumbbell.service;

import es.uma.ingsoftware.goldendumbbell.model.Producto;
import es.uma.ingsoftware.goldendumbbell.repository.Productorepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Productoservice {

    @Autowired
    Productorepository productorepository;

    public List<Producto> getAll(){
        return productorepository.findAll();
    }

    public void save(Producto p){
        productorepository.saveAndFlush(p);
    }
}
