package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class Alimento {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private int gramos;
    private int N_Dieta;
    private String comida;

    public Alimento(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alimento alimento)) return false;
        return getId() == alimento.getId() && getGramos() == alimento.getGramos() && Objects.equals(getName(), alimento.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getGramos());
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "Nombre='" + name + '\'' +
                ",Gramos=" + gramos +
                '}';
    }
}
