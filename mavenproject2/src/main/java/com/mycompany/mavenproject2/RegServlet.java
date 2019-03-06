/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author javaee
 */
@WebServlet(name = "RegServlet", urlPatterns = {"/reg"})
public class RegServlet extends HttpServlet {

    UserRepository repo = new  UserRepository();
    UserService us = new UserService();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet RegServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet RegServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                try (PrintWriter out = response.getWriter()) {
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");         
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Regisztráció</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<form action=\"reg\" method=\"post\">");
                        out.println("<input type=\"username\" name=\"username\" placeholder=\"Felhasználónév\">");
                        out.println("<input type=\"password\" name=\"password\" placeholder=\"Jelszó\">");
                        out.println("<input type=\"submit\" value=\"Regisztráció\">");
                    out.println("</form>");
                    out.println("</body>");
                    out.println("</html>");
                }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            

            
            response.setContentType("text/html;charset=UTF-8");
            
                String name = request.getParameter("username"), passw = request.getParameter("password");
                
                if (getServletContext().getAttribute("users") == null) {
                    getServletContext().setAttribute("users", new ArrayList<User>());
                }
                
                User user = new User(name, passw);
                if (!us.isExist(user)) {
                    //((ArrayList<User>)getServletContext().getAttribute("users") ).add(user);
                    repo.Add(user);
                }
            
                try(PrintWriter out = response.getWriter()){
                    for (User u : repo.getAll()) {
                        out.print(u.getName() + "\n");
                    }
                };
            
            
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
