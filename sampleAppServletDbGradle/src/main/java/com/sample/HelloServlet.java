package com.sample;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class HelloServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(
                "jdbc:h2:tcp://localhost/db/sample", "sa", "");
            conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
            return;
        }

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>Hello SimpleServlet</h1>");
        response.getWriter().println("session="+request.getSession(true).getId());
    }
}
