package es.uma.ingsoftware.goldendumbbell.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;


@Entity
public class Usuario {

    //Pensar un toString
    //Que comparamos en el hash code
    @Id
    @GeneratedValue
    private Integer id; //es para la base de datos es importante
    private String nombreUsuario;
    private String contraseña;
    private double peso;
    private int altura; //Centimetros
   private String rol;
    private String correo;
    private int telefono;
    private Date nacimiento;

    public Usuario(){

    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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

    public void setId(int id) {
        this.id = id;
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
                ", Nombre completo='" + nombreUsuario + '\'' +
                ", Correo='" + correo + '\'' +
                '}';
    }
}


