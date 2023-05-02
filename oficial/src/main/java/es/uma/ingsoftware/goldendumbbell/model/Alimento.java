package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Alimento {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer gramos;
    private Integer n_dieta;
    private String comida;

    public Alimento() {

    }

    public Integer  getN_dieta() {
        return n_dieta;
    }

    public void setN_dieta(Integer n_dieta) {
        this.n_dieta = n_dieta;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer  getGramos() {
        return gramos;
    }

    public void setGramos(int gramos) {
        this.gramos = gramos;
    }

    public void setGramos(Integer gramos) {
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
