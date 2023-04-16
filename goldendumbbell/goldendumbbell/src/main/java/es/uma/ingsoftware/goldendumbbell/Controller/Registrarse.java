package es.uma.ingsoftware.goldendumbbell.Controller;
import java.util.Date;
import java.util.Scanner;

import java.sql.*;

public class Registrarse {
    private static Connection con;

    public static void main(String args[]) throws SQLException {

        Scanner sc = new Scanner(System.in);
        int id; //es para la base de datos es importante
        String nombre;
        String contraseña;-+*//**
        double peso;
        int altura; //Centimetros
        String correo;
        int telefono;
        Date nacimiento = 22.02 - 2021;
        String tabla = "USUARIO", consulta;

        System.out.print("Introduzca su nombre: ");
        nombre = sc.nextLine();  //leer un String

        System.out.print("Introduzca su contraseña: ");
        contraseña = sc.nextLine();  //leer un String

        System.out.print("Introduzca su peso: ");
        peso = sc.nextDouble();  //leer un String

        System.out.print("Introduzca su altura: ");
        altura = sc.nextInt();  //leer un String

        System.out.print("Introduzca su correo: ");
        correo = sc.nextLine();  //leer un String

        System.out.print("Introduzca su telefono: ");
        telefono = sc.nextInt();

       // System.out.print("Introduzca su fecha de nacimiento: ");
       // nacimiento = sc.nextByte();


        /* Registro del controlador */
        //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        System.out.println("Controlador registrado");

        /* Cadena de conexión */
        System.out.println("\nEstableciendo conexión...");
        con = DriverManager.getConnection("jdbc:oracle:thin:@afrodita.lcc.uma.es:1521:Apolo", "UBD4193", "goldend1234");
        System.out.println("Conexión establecida\n");

        /* Objeto Statement: contiene métodos para ejecutar consultas
         * (executeQuery para SELECT, executeUpdate para INSERT, UPDATE, DELETE)*/
        Statement stmt = con.createStatement();

        verTabla(tabla);

        /* Ejecución de la sentencia SQL */
        try {
            System.out.println("Iniciando transacción...");
            consulta = "INSERT INTO PRODUCTO(id, nombre, cantidad, precio)\n" +
                    "VALUES(" + id + ", '" + nombre + "', " + cantidad + ", " + precio +")";
            System.out.println("Se va a ejecutar la consulta:\n" + consulta);
            stmt.executeUpdate(consulta);
            System.out.println("Inserción finalizada");
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Error: en la consulta " + e.getLocalizedMessage());
        }

        verTabla(tabla);

        /* Cierre de descriptores */
        System.out.println("Finalizando transacción...");
        stmt.close();
        con.close();
        System.out.println("\nConexión finalizada");

    }

    private static void verTabla(String tabla) throws SQLException {
        System.out.println("\nContenido de la tabla " + tabla + ":");
        Statement stmt = con.createStatement();
        ResultSet rset = stmt.executeQuery("SELECT * FROM " + tabla);

        while (rset.next()) {
            int ncol = rset.getMetaData().getColumnCount();
            for (int i = 1; i <= ncol; i++) {
                System.out.print(rset.getString(i));
                if (i < ncol)
                    System.out.print(" | ");
            }
            System.out.println();
        }

        stmt.close();
        System.out.println();
    }
}