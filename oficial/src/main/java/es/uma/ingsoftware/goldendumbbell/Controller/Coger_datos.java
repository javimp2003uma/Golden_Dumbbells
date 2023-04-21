package es.uma.ingsoftware.goldendumbbell.Controller;

import java.sql.*;


public class Coger_datos {

    public static void main(String args[]) throws SQLException {

        /* Registra el objeto driver dado. DriverManager es el servicio básico
           para gestionar un conjunto de drivers JDBC. */
        //DriverManager.registerDriver(new );
        System.out.println("Controlador registrado");

        /* Establece la conexión con DriverManager.getConnection(), pasando la
           URL de conexión a la base de datos y los parámetros usuario y contraseña */
        System.out.println("\nEstableciendo conexión...");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@afrodita.lcc.uma.es:1521:Apolo", "UBD4193", "goldend1234");
        System.out.println("Conexión establecida\n");
        /* Crea un objeto Statement para enviar sentencias SQL a la base de datos */
        Statement stmt = con.createStatement();

        /* Ejecuta la sentencia SQL dada, lo cual devuelve un objeto ResultSet
           Un objeto ResultSet es una tabla de datos que representa un conjunto
           de resultados de la base de datos, el cual mantiene un cursor que
           apunta a la fila actual de los datos. */
        String consulta = "SELECT * FROM USUARIO";
        System.out.println("Se va a ejecutar la consulta: " + consulta);
        System.out.println("\nIniciando transacción...");
        ResultSet rset = stmt.executeQuery(consulta);
        /* El método next() mueve el cursor a la siguiente fila. Como devuelve
           falso cuando no hay más filas, puede usarse en un bucle while para
           iterar a través del conjunto resultados. */
        System.out.println("Resultado de la consulta:");
        while (rset.next()) { // while: Itera sobre las filas del resultado
            /* getString() recupera el valor de la columna designada en su
               argumento como un String de Java. */
            int ncol = rset.getMetaData().getColumnCount();
            for (int i = 1; i <= ncol; i++) { // for: Itera sobre las columnas de la fila
                System.out.print(rset.getString(i));
                if (i < ncol)
                    System.out.print(" | ");
            }
            System.out.println();
        }
        /* Libera la base de datos del objeto ResultSet y los recursos JDBC. */
        System.out.println("Finalizando transacción...");
        stmt.close();
        con.close();
        System.out.println("\nConexión finalizada");
    }
}