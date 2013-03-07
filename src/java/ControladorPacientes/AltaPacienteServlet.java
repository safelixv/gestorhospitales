/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPacientes;

import DAO.GestorHospitalesDAO;
import DAO.PacienteDAOMysql;
import Pojos.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vesprada
 */
public class AltaPacienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        try {
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
            String DNI = request.getParameter("DNI");
            String NSS = request.getParameter("NSS");
            String sexo = request.getParameter("sexo");
            String habitacionId = request.getParameter("habitacion_id");
            Paciente paciente = new Paciente();
            paciente.setNombre(nombre);
            paciente.setApellidos(apellidos);
            paciente.setTelefono(Integer.parseInt(telefono));
            paciente.setDNI(DNI);
            paciente.setDireccion(direccion);
            paciente.setNSS(NSS);
            paciente.setSexo(sexo);
            paciente.setHabitacionId(Integer.parseInt(habitacionId));
            GestorHospitalesDAO.getInstance().getPacienteDAO().altaPacientes(paciente);
            
        } finally {
            RequestDispatcher d = request.getRequestDispatcher("index.jsp");
            d.forward(request, response);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
