/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladorHospitales;


import DAO.HospitalDAO;
import Pojos.Hospital;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alejandro
 */
public class InfoHospitalServlet extends HttpServlet {

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
            ArrayList<Hospital> listaHospitales = new ArrayList();
            HospitalDAO hospitalDAO = new HospitalDAO();
            String hospitalId = request.getParameter("id");
            try {
                Thread.sleep(1000); //se puede variar el retardo
            } catch (InterruptedException e) {
            }
            
            if (hospitalId.equals("all")) {
                listaHospitales = hospitalDAO.recuperaHospitales();
                String info = new Gson().toJson(listaHospitales);
                out.print(info);

            } else {                
                int idInt = Integer.parseInt(hospitalId);                
                Hospital hospital = hospitalDAO.recuperaHospital(idInt);
                String info = new Gson().toJson(hospital);
                out.print(info);
            }


        } catch (Exception ex) {
            Logger.getLogger(InfoHospitalServlet.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
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
