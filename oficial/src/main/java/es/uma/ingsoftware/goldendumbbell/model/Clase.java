package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Clase {

    @Id
    private Integer id;
    private String nombre;
    private String hora;
    private Integer n_usuario;

    public Integer getN_usuario() {
        return n_usuario;
    }

    public void setN_usuario(Integer n_usuario) {
        this.n_usuario = n_usuario;
    }

    public String getName() {
        return nombre;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setName(String name) {
        this.nombre = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Clase() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clase clase = (Clase) o;
        return Objects.equals(nombre, clase.nombre) && Objects.equals(hora, clase.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, hora);
    }

    @Override
    public String toString() {
        return "Clase{" +
                ", Name='" + nombre + '\'' +
                ",Hora=" + hora +
                '}';
    }
}
