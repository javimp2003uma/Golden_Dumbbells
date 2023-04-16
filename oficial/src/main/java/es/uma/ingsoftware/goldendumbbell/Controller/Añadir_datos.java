package es.uma.ingsoftware.goldendumbbell.Controller;

import java.sql.*;

public class Añadir_datos {
    private static Connection con;

    public static void main(String args[]) throws SQLException {
        int id = 14,cantidad = 1,precio = 30;
        String nombre = "Whey protein";
        String tabla = "PRODUCTO", consulta;

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