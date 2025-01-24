package br.com.srvletapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.jbcrypt.BCrypt;

import br.com.srvletapi.classes.User;
import br.com.srvletapi.exceptions.RecordNotFoundException;
import br.com.srvletapi.exceptions.RecordNotFoundException;

public class UserDao {
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }


    public void store(User user) throws SQLException{
        String sql = "INSERT INTO \"user\" (username, email, password, role) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, user.getUsername());
        stmt.setString(2, user.getEmail());
        stmt.setString(3, BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        stmt.setString(4, user.getRole());

        stmt.executeUpdate();
    }

    public User findById(int id) throws SQLException{
        // Cria um usuário para retornar
        User user = new User();

        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(0, id);
        ResultSet rs = stmt.executeQuery();

        if(rs.next()){
            user.setId(Integer.parseInt(rs.getString("id")));
            user.setUsername(rs.getString("username"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRole(rs.getString("role"));
        }

        return user;
    }

    public User findByUsername(String username) throws SQLException, RecordNotFoundException{

        String sql = "SELECT * FROM user WHERE username = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return mapResultSetToUser(rs);
        } else {
            throw new RecordNotFoundException("User with username '" + username + "' not found.");
        }
    }

    public User findByEmail(String email) throws SQLException, RecordNotFoundException{

        String sql = "SELECT * FROM user WHERE email = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return mapResultSetToUser(rs);
        } else {
            throw new RecordNotFoundException("User with email '" + email + "' not found.");
        }
    }

    private User mapResultSetToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id")); // Use getInt para id se o tipo for INTEGER no banco
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));
        return user;
    }


}
