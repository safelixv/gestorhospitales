/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author ACE
 */
public class GestorHospitalesDAO {
    private HabitacionDAO habitacionDAO;
    private PacienteDAO pacienteDAO;
    private HospitalDAO hospitalDAO;
    private static GestorHospitalesDAO instance=null;
    
    public static GestorHospitalesDAO getInstance(){
        if (instance == null){
            instance=new GestorHospitalesDAO();
        }
        return instance;
    }
    
    private GestorHospitalesDAO(){
        habitacionDAO= new HabitacionDAOMysql();
        pacienteDAO= new PacienteDAOMysql();
        hospitalDAO= new HospitalDAOMysql();
        
      //  habitacionDAO= new HabitacionDAOHibernate();
      //  pacienteDAO= new PacienteDAOHibernate();
      //  hospitalDAO= new HospitalDAOHibernate();
    }

    public HabitacionDAO getHabitacionDAO() {
        return habitacionDAO;
    }

    public HospitalDAO getHospitalDAO() {
        return hospitalDAO;
    }

    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }
    
    
    
    
    
}
