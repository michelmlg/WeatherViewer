package br.com.srvletapi.service;

import org.json.JSONObject;
import org.mindrot.jbcrypt.BCrypt;

import br.com.srvletapi.classes.User;
import br.com.srvletapi.classes.UserValidation;
import br.com.srvletapi.dao.UserDao;

public class AuthService {
    private UserDao userDao;

    public AuthService(UserDao userDao) {
        this.userDao = userDao;
    }

    public JSONObject registerUser(User user) throws Exception {
        UserValidation.validateUser(user);
        userDao.store(user);

        return new JSONObject()
            .put("status", "success")
            .put("message", "Usuário registrado com sucesso!")
            .put("user", user.toJsonResponse().toString());
    }

    public JSONObject loginUser(String method, String credential, String password) throws Exception {
        User user = method.equals("username")
            ? userDao.findByUsername(credential)
            : userDao.findByEmail(credential);

       

        if (user == null || !BCrypt.checkpw(password, user.getPassword())) {
            throw new Exception("Credenciais inválidas!");
        }

        return new JSONObject()
            .put("status", "success")
            .put("message", "Usuário logado com sucesso!");
    }
}
