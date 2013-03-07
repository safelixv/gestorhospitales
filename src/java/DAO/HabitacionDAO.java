/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojos.Habitacion;
import java.util.ArrayList;

/**
 *
 * @author ACE
 */
public interface HabitacionDAO {

    Habitacion recuperaHabitacion(int id);

    ArrayList<Habitacion> recuperaHabitaciones();
    
}
