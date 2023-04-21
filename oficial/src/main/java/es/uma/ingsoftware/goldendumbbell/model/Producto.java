package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;


@Entity
public class Producto {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombreProducto;
    private Integer cantidad;
    private double precio;

    public Producto() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer  getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto producto)) return false;
        return Double.compare(producto.getPrecio(), getPrecio()) == 0 && Objects.equals(getNombreProducto(), producto.getNombreProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNombreProducto(), getPrecio());
    }

    @Override
    public String toString() {
        return "Producto{" +
                "Nombre='" + nombreProducto + '\'' +
                ", Cantidad=" + cantidad +
                ", Precio=" + precio +
                "€ }";
    }
}
