package br.com.srvletapi.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//classes import
import org.json.JSONObject;


@WebServlet(name = "dbInfoService", urlPatterns = { "/dbinfo" })
public class DatabaseInfoServlet extends HttpServlet{
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
		
        String dbname = System.getenv("DB_NAME");
        String dbuser = System.getenv("DB_USER");
        String dbpass = System.getenv("DB_PASSWORD");
        
        JSONObject response = new JSONObject();
        response.put("status", "success");
        response.put("message", "Returning DB connection info.");
        response.put("dbname", dbname);
        response.put("username", dbuser);
        response.put("password", dbpass);


        resp.getWriter().write(response.toString());
	}
    
}
