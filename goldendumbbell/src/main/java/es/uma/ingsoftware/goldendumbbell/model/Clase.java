package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Clase {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Date hora;
    private int numUsuarios;
    //private List<Usuario> usuarios;

    public String getName() {
        return name;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getHora() {
        return hora;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return Objects.equals(name, clase.name) && Objects.equals(hora, clase.hora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hora);
    }

    @Override
    public String toString() {
        return "Clase{" +
                ", Name='" + name + '\'' +
                ",Hora=" + hora +
                '}';
    }
}
