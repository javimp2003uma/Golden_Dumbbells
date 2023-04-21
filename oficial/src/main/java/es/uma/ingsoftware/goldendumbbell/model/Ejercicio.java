package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Ejercicio {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private int repeticiones;
    private double peso;
    private int n_rutina;

    public Ejercicio(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getN_rutina() {
        return n_rutina;
    }

    public void setN_rutina(int n_rutina) {
        this.n_rutina = n_rutina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(int repeticiones) {
        this.repeticiones = repeticiones;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ejercicio ejercicio)) return false;
        return getId() == ejercicio.getId() && getRepeticiones() == ejercicio.getRepeticiones() && Double.compare(ejercicio.getPeso(), getPeso()) == 0 && Objects.equals(getNombre(), ejercicio.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getRepeticiones(), getPeso());
    }

    @Override
    public String toString() {

        if(peso == 0){
            return "Ejercicio{" +
                    "nombre='" + nombre + '\'' +
                    ", Repeticiones=" + repeticiones +
                    '}';

        }else {
            return "Ejercicio{" +
                    "nombre='" + nombre + '\'' +
                    ", Repeticiones=" + repeticiones +
                    ", Peso=" + peso +
                    '}';
        }
    }
}
