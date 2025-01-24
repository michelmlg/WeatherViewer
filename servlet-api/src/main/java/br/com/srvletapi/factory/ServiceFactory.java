package br.com.srvletapi.factory;

import java.sql.Connection;

import br.com.srvletapi.DBConnection;
import br.com.srvletapi.dao.UserDao;
import br.com.srvletapi.service.AuthService;

public class ServiceFactory {
    public static AuthService createAuthService(){
        
        try{
            Connection connection = DBConnection.createConnection(); // Cria a conexão
            UserDao userDao = new UserDao(connection); // Injeta a conexão no UserDao
            return new AuthService(userDao); // Injeta o UserDao no AuthService
        }catch(Exception e){
            return null;
        }
    }
}
