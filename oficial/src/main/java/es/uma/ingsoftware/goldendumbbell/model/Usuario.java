package es.uma.ingsoftware.goldendumbbell.model;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
public class Usuario {

    //Pensar un toString
    //Que comparamos en el hash code
    @Id
    @GeneratedValue
    private Integer id; //es para la base de datos es importante
    private String nombreusuario;
    private String contrasena;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date nacimiento;
    private double peso;
    private Integer altura; //Centimetros
    private String correo;
    private Integer telefono;
    private String rol;


    @ManyToMany(mappedBy = "asistentes")
    List<Clase> clases;

    @ManyToMany(mappedBy = "hola")
    List<Carrito> carrito;


    public Usuario(){

    }


    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContrasena() {
        return contrasena;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public List<Carrito> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Carrito> carrito) {
        this.carrito = carrito;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreusuario;
    }

    public void setNombreUsuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario usuario)) return false;
        return getId() == usuario.getId() && Objects.equals(getNombreUsuario(), usuario.getNombreUsuario()) && Objects.equals(getNacimiento(), usuario.getNacimiento());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombreUsuario(), getNacimiento());
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Identificador=" + id +
                ", Nombre completo='" + nombreusuario + '\'' +
                ", Correo='" + correo + '\'' +
                '}';
    }
}


