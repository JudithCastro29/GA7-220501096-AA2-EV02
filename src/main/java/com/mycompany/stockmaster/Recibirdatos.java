package com.mycompany.stockmaster;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;

@WebServlet(name = "Recibirdatos", urlPatterns = {"/Recibirdatos"})
public class Recibirdatos extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
       //Datos de conexión a la base de datos
       String usuarioDB ="root";
       String passwordDB = "";
       String url = "jdbc:mysql://localhost:3306/stockmaster";
  
       
       
       //Obtener datos del formulario
       String user = request.getParameter("user");
       String password = request.getParameter("password");
       
       
       
       //objetos de conexion
        Connection conexion = null; 
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(url,usuarioDB,passwordDB);
               
        
        // preparar consulta
        String query = "SELECT * FROM usuario WHERE idusuario=? AND Contraseña=?  ";
        ps = conexion.prepareStatement(query);
        ps.setString(1, user);
        ps.setString(2, password);
        
        
        //Ejecutar consulta
        rs = ps.executeQuery();
        
        // consulta verdadera
            if (rs.next()) {
             request.setAttribute("usuario", user);
                RequestDispatcher dispatcher = request.getRequestDispatcher("panel.jsp");
                dispatcher.forward(request, response);
               // No se encuenta el usuario                 
            } else {
                request.setAttribute("mensajeError", "Usuario o Contraseña incorrecta");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response);
            }
            
        
        }catch (SQLException | ClassNotFoundException ex) {
           request.setAttribute("mensajeError", "Error al conectar con la base de datos");
                RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
                dispatcher.forward(request, response); 
        } finally{
            try {
             if (rs != null ) rs.close ();
             if (ps != null ) ps.close ();
             if (conexion != null ) conexion.close ();
             
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
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
        processRequest(request, response);
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
        processRequest(request, response);
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
