package DAO;

import Database.MySQL;
import Pojos.Hospital;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class HospitalDAOMysql implements HospitalDAO {

    @Override
    public  Hospital recuperaHospital(Integer id) throws Exception {
        try {
            MySQL.conexion();
            String sql = "SELECT * FROM hospital WHERE ID=" + id;
            ResultSet result = MySQL.get(sql);
            Hospital hospital = new Hospital();
            if (result.next()) {
                hospital.setId(result.getInt("id"));
                hospital.setDireccion(result.getString("direccion"));
                hospital.setNombre(result.getString("nombre"));
                hospital.setTelefono(result.getInt("telefono"));
                hospital.setPersonal(result.getString("personal"));
                hospital.setSalas(result.getInt("salas"));
                
            }
            return hospital;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public  ArrayList<Hospital> recuperaHospitales() {

        ArrayList<Hospital> listaHospitales = new ArrayList();
        try {
            MySQL.conexion();
            String sql = "SELECT * FROM hospital";
            ResultSet rs = MySQL.get(sql);
            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setId(rs.getInt("id"));                
                hospital.setDireccion(rs.getString("direccion"));
                hospital.setNombre(rs.getString("nombre"));
                hospital.setTelefono(rs.getInt("telefono"));
                hospital.setPersonal(rs.getString("personal"));
                hospital.setSalas(rs.getInt("salas"));
                listaHospitales.add(hospital);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaHospitales;
    }
    
    @Override
    public  void editarHospitales(Hospital hospital) {
        try {
            MySQL.conexion();
            MySQL.updateOne(hospital.getId(), "hospital", "nombre", hospital.getNombre());
            MySQL.updateOne(hospital.getId(), "hospital", "direccion", hospital.getDireccion());
            MySQL.updateOne(hospital.getId(), "hospital", "telefono", "" + hospital.getTelefono());
            MySQL.updateOne(hospital.getId(), "hospital", "personal", "" + hospital.getPersonal());
            MySQL.updateOne(hospital.getId(), "hospital", "salas", "" + hospital.getSalas());            
            MySQL.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(HospitalDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public  void altaHospitales(Hospital hospital) {
        try {
            MySQL.conexion();
            Integer id=MySQL.insertOne("hospital");            
            MySQL.updateOne(id, "hospital", "nombre", hospital.getNombre());
            MySQL.updateOne(id, "hospital", "direccion", hospital.getDireccion());
            MySQL.updateOne(id, "hospital", "telefono", "" + hospital.getTelefono());
            MySQL.updateOne(id, "hospital", "personal", "" + hospital.getPersonal());
            MySQL.updateOne(id, "hospital", "salas", "" + hospital.getSalas());
            MySQL.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(HospitalDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public  void bajaHospitales(Integer id) {
        try {
            MySQL.conexion();
            MySQL.removeOne(id, "hospital");
            MySQL.desconexion();
            MySQL.commitTrans();
        } catch (Exception ex) {
            Logger.getLogger(HospitalDAOMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
