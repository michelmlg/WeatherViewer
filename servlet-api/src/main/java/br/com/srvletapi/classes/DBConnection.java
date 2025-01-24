package br.com.srvletapi.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection createConnection() throws SQLException, ClassNotFoundException{
        String url = "jdbc:postgresql://host.docker.internal:5433/" + System.getenv("DB_NAME"); 
        String username = System.getenv("DB_USER");
        String password = System.getenv("DB_PASSWORD");

        // Tentando estabelecer a conexão com o banco de dados
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void closeConnection(Connection conn) throws SQLException{
        if(conn.isClosed() || !conn.isValid(1000)){
            return;
        }

        conn.close(); 
    }
}
