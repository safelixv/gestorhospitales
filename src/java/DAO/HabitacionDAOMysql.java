/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.MySQL;
import Pojos.Habitacion;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class HabitacionDAOMysql implements HabitacionDAO {

    @Override
    public Habitacion recuperaHabitacion(int id) {
       try {
            MySQL.conexion();
            String sql = "SELECT * FROM habitaciones WHERE ID=" + id;
            ResultSet result = MySQL.get(sql);
            Habitacion habitacion = new Habitacion();
            if (result.next()) {
                habitacion.setId(result.getInt("id"));
                habitacion.setNumero(result.getInt("numero"));                
                habitacion.setTelefono(result.getInt("telefono"));
                habitacion.setHospitalId(result.getInt("hospital_id"));
            }
            return habitacion;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public ArrayList<Habitacion> recuperaHabitaciones() {
       ArrayList<Habitacion> listaHabitaciones = new ArrayList();
        try {
            MySQL.conexion();
            String sql = "SELECT * FROM habitaciones";
            ResultSet rs = MySQL.get(sql);
            while (rs.next()) {
                Habitacion habitacion = new Habitacion();
                habitacion.setId(rs.getInt("id"));
                habitacion.setNumero(rs.getInt("numero"));                
                habitacion.setTelefono(rs.getInt("telefono"));
                habitacion.setHospitalId(rs.getInt("hospital_id"));
                listaHabitaciones.add(habitacion);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaHabitaciones;
    }
    
    
    
    
}
