package com.simplilearn.servlet;

import java.io.IOException;  
import java.io.PrintWriter;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import javax.servlet.http.HttpSession;  
public class DashBoardServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                      throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
//        request.getRequestDispatcher("link.html").include(request, response);  
          
        HttpSession session=request.getSession(false);  
        if(session!=null){  
            request.getRequestDispatcher("linkLogout.html").include(request, response);          	
            String name=(String)session.getAttribute("name");  
          
            out.println("Hello "+name+", Welcome to Dashboard");
            out.println("No items to display today"); 
        }  
        else{  
 
            out.print("Please login first");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  
        out.close();  
    }  
}  