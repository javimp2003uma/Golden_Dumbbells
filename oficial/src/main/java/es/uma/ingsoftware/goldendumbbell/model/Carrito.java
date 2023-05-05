package es.uma.ingsoftware.goldendumbbell.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
public class Carrito {
    @Id
    @GeneratedValue
    private Integer id;
    private String nombreproducto;
    private Integer cantidad;
    private double precio;

    @OneToOne()
    public Usuario hola;

    public Carrito() {

    }


    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public Usuario getCompras() {
        return hola;
    }

    public void setCompras(Usuario compras) {
        this.hola = compras;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreproducto;
    }

    public void setNombreProducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
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
                "Nombre='" + nombreproducto + '\'' +
                ", Cantidad=" + cantidad +
                ", Precio=" + precio +
                "€ }";
    }
}
