package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;
@Entity
public class Noticia {

    @Id
    @GeneratedValue
    private Integer id;
    private String titulo;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechadpublicacion;
    private String cuerpo;

    public Noticia(){

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInfo() {
        return cuerpo;
    }

    public void setInfo(String info) {
        this.cuerpo = cuerpo;
    }

    public Date getFechadpublicacion() {
        return fechadpublicacion;
    }

    public void setFechadpublicacion(Date fechadpublicacion) {
        this.fechadpublicacion = fechadpublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
