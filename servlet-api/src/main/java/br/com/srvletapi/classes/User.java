package br.com.srvletapi.classes;

import org.json.JSONObject;

public class User {
    private Integer id;
    private String username;
    private String email;
    private String password;
    private String role;

    public User() {
        this.id = null;
        this.username = "";
        this.email = "";
        this.password = "";
        this.role = "";
    }
    public User(String username, String email, String password, String role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(int id,String username, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public JSONObject toJsonResponse() {
        JSONObject json = new JSONObject();

        if (this.id != null) { 
            json.put("id", this.id);
        } else {
            json.put("id", JSONObject.NULL);
        }

        json.put("username", this.username);
        json.put("email", this.email);
        json.put("role", this.role);
        json.put("password", this.password); // Nota: incluir "password" no JSON pode não ser seguro
        return json;
    }
    
    @Override
    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
