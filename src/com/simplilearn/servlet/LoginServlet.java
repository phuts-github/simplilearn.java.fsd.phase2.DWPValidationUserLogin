package com.simplilearn.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;  
public class LoginServlet extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
          
        if(name.contentEquals("admin") && password.equals("admin123")){  
        	request.getRequestDispatcher("linkLogoutDashboard.html").include(request, response);
        	out.print("Welcome, "+name);  
        	HttpSession session=request.getSession();  
        	session.setAttribute("name",name);  
        }  
        else{  
            out.print("Sorry, username or password error!");
            out.print("<br/>");
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();   
    }  
} 