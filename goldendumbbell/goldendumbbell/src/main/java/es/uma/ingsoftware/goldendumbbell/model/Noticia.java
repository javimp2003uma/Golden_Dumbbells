package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;
@Entity
public class Noticia {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    private String info;
    private Date fechadpublicacion;
    public Noticia(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getFechadpublicacion() {
        return fechadpublicacion;
    }

    public void setFechadpublicacion(Date fechadpublicacion) {
        this.fechadpublicacion = fechadpublicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Noticia noticia)) return false;
        return getId() == noticia.getId() && Objects.equals(getTitulo(), noticia.getTitulo()) && Objects.equals(getFechadpublicacion(), noticia.getFechadpublicacion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitulo(), getFechadpublicacion());
    }

    //El toString no se como puede ser el de una imagen
}
