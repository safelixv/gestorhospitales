/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorPacientes;

import DAO.PacienteDAOMysql;
import Pojos.Paciente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vesprada
 */
@WebServlet(name = "controlador", urlPatterns = {"/controlador"})
public class InfoPacienteServlet extends HttpServlet {

    private Gson gson = new Gson();
    private int numeroItemsPaginas = 4;

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
            ArrayList<Paciente> listaPacientes = new ArrayList();
            PacienteDAOMysql pacienteDAO = new PacienteDAOMysql();
            String id = request.getParameter("id");

            if (id.equals("all")) {
                listaPacientes = pacienteDAO.recuperaPacientes();
                String info = gson.toJson(listaPacientes);
                out.print(info);

            }
            if (id.matches("^[0-9]*")) {
                try {
                    Thread.sleep(1000); //se puede variar el retardo
                } catch (InterruptedException e) {
                }
                int idInt = Integer.parseInt(id);
                Paciente paciente = pacienteDAO.recuperaPaciente(idInt);
                String info = gson.toJson(paciente);
                out.print(info);
            }

            if (id.equalsIgnoreCase("getrecords")) {

                List<Paciente> pacientes = pacienteDAO.recuperaPacientes();
                out.print(gson.toJson(pacientes.size()));
            }
            if (id.equalsIgnoreCase("getpages")) {

                List<Paciente> oListaSeries = new ArrayList<>();
                oListaSeries = pacienteDAO.recuperaPacientes();
                int div = oListaSeries.size() / numeroItemsPaginas;
                int resto = oListaSeries.size() % numeroItemsPaginas;
                if (resto > 0) {
                    div++;
                }
                out.print(gson.toJson(div));
            }
            if (id.equalsIgnoreCase("getpage")) {
                Integer page = Integer.parseInt(request.getParameter("page"));
                List<Paciente> pacientes = new ArrayList<>();
                pacientes = pacienteDAO.recuperaPacientes();
                int desde = (page - 1) * numeroItemsPaginas;
                int hasta = (page * numeroItemsPaginas);
                if (hasta > pacientes.size()) {
                    hasta = pacientes.size();
                }
                List<Paciente> listaSeries = pacientes.subList(desde, hasta);
                String json = gson.toJson(listaSeries);
                out.print(json);
            }



        } catch (Exception ex) {
            Logger.getLogger(InfoPacienteServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
