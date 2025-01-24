package br.com.srvletapi.controller;

import java.io.IOException;
// import java.util.List;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.Exception;


//classes import
import org.json.JSONObject;

import br.com.srvletapi.classes.User;
import br.com.srvletapi.factory.ServiceFactory;
import br.com.srvletapi.service.AuthService;
import br.com.srvletapi.ParameterHandling;
import br.com.srvletapi.RequestBodyReader;

@WebServlet(name = "userService", urlPatterns = {"/user/register", "/user/login"})
public class AuthController extends HttpServlet {

    private final AuthService authService = ServiceFactory.createAuthService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        var writer = resp.getWriter();

        String requestUri = req.getRequestURI();
        var body = RequestBodyReader.readRequestBody(req.getReader());

        try {
            if (requestUri.endsWith("/register")) {
                handleRegister(writer, body);
            } else if (requestUri.endsWith("/login")) {
                handleLogin(writer, body);
            }
        } catch (Exception e) {
            handleException(writer, e);
        } finally {
            writer.flush();
            writer.close();
        }
    }

    private void handleRegister(PrintWriter writer, JSONObject body) throws Exception {
        String username = ParameterHandling.getRequiredKey(body, "username");
        String email = ParameterHandling.getRequiredKey(body, "email");
        String password = ParameterHandling.getRequiredKey(body, "password");

        User user = new User(username, email, password, "user");
        JSONObject response = authService.registerUser(user);
        writer.write(response.toString());
    }

    private void handleLogin(PrintWriter writer, JSONObject body) throws Exception {
        String method = ParameterHandling.getRequiredKey(body, "method");
        String credential = method.equals("username")
                ? ParameterHandling.getOptionalKey(body, "username")
                : ParameterHandling.getOptionalKey(body, "email");
        String password = ParameterHandling.getRequiredKey(body, "password");

        JSONObject response = authService.loginUser(method, credential, password);
        writer.write(response.toString());
    }

    private void handleException(PrintWriter writer, Exception e) throws IOException {
        writer.write(new JSONObject()
                .put("status", "error")
                .put("message", e.getMessage())
                .put("exception", e.toString())
                .put("code", e.hashCode())
                .toString());
    }
}


