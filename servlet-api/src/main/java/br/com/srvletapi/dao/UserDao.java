package br.com.srvletapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import br.com.srvletapi.classes.User;

public class UserDao {

    public static boolean store(Connection conn, User user) throws SQLException{
        String sql = "INSERT INTO \"user\" (username, email, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        stmt.setString(4, user.getRole());

        stmt.executeUpdate();
        
        return true;
    }

    public User findById(Connection conn, int id) throws SQLException{
        // Cria um usuário para retornar
        User user = new User();

        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setInt(0, id);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }

    public User findByUsername(Connection conn, String username) throws SQLException{
        // Cria um usuário para retornar
        User user = new User();

        String sql = "SELECT * FROM user WHERE username = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(0, username);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }

    public User findByEmail(Connection conn, String email) throws SQLException{
        // Cria um usuário para retornar
        User user = new User();

        String sql = "SELECT * FROM user WHERE email = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        
        stmt.setString(0, email);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }


}
