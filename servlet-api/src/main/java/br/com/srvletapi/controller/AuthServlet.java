package br.com.srvletapi.controller;

import java.io.IOException;
// import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Exception;

//classes import
import org.json.JSONObject;
import br.com.srvletapi.classes.User;
import br.com.srvletapi.service.UserService;
import br.com.srvletapi.classes.ParameterHandling;
import br.com.srvletapi.classes.RequestBodyReader;

@WebServlet(name = "userService", urlPatterns = { "/user/register", "/user/login" })
public class AuthServlet extends HttpServlet{

    @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        var writer = resp.getWriter();
        String requestUri = req.getRequestURI();
        var body = RequestBodyReader.readRequestBody(req.getReader());


        if(requestUri.endsWith("/register")){
            try {
                String username = ParameterHandling.getRequiredKey(body, "username");
                String email = ParameterHandling.getRequiredKey(body, "email");
                String password = ParameterHandling.getRequiredKey(body, "password");

                User user = new User(username, email, password, "user");

                if(UserService.registerUser(user)){
                    writer.write(
                        new JSONObject()
                            .put("status", "success")
                            .put("message", "Usuário registrado com sucesso!")
                            .put("user", user.toJsonResponse().toString())
                            .toString()
                    );
                }
            } catch (Exception e) {
                writer.write(
                    new JSONObject()
                        .put("message", e.getMessage())
                        .put("exception", e)
                        .put("code", e.hashCode())
                        .toString()
                );
            } finally {
                writer.flush();
                writer.close();
            }

        }

        if(requestUri.endsWith("/login")){
            

            

        }

       
	}

    // private void handleLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    // }

    // private HttpServletResponse handleRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
    //     var body = RequestBodyReader.readRequestBody(req.getReader());
    
    //     String username = ParameterHandling.getRequiredKey(body, "username");
    //     String email = ParameterHandling.getRequiredKey(body, "email");
    //     String password = ParameterHandling.getRequiredKey(body, "password");

    //     User user = new User(username, email, password, "user");
    //     Connection con = DBConnection.createConnection();

    //     if(UserDao.store(con, user)){
    //         writer.write(
    //             new JSONObject()
    //                 .put("status", "success")
    //                 .put("message", "Usuário registrado com sucesso!")
    //                 .put("user", user.toJsonResponse().toString())
    //                 .toString()
    //         );
    //     }

    //     DBConnection.closeConnection(con);
    // }
    
}
