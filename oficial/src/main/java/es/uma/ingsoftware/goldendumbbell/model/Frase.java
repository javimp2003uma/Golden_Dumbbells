package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Frase {

    @Id
    @GeneratedValue
    private Integer id;
    private String frase;

    public Frase(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Frase that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getFrase(), that.getFrase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFrase());
    }

    @Override
    public String toString() {
        return frase;
    }
}
