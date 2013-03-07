/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojos.Hospital;
import java.util.ArrayList;

/**
 *
 * @author ACE
 */
public interface HospitalDAO {

    void altaHospitales(Hospital hospital);

    void bajaHospitales(Integer id);

    void editarHospitales(Hospital hospital);

    Hospital recuperaHospital(Integer id) throws Exception;

    ArrayList<Hospital> recuperaHospitales();
    
}
