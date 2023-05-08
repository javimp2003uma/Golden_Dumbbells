package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Clase {

    @Id
    @GeneratedValue
    private Integer id;
    private String nombre;
    private String hora;
    private Integer n_usuario;

    @ManyToMany
            @JoinTable(
                    name = "clase_asistentes",
                    joinColumns = @JoinColumn(name = "asistentes_id"),
                    inverseJoinColumns = @JoinColumn(name = "clases_id"))
    List<Usuario> asistentes;

    

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getAsistentes() {
        return asistentes;
    }

    public void setAsistentes(List<Usuario> asistentes) {
        this.asistentes = asistentes;
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
