/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Database.MySQL;
import Pojos.Paciente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vesprada
 */
public class PacienteDAO {

    public static Paciente recuperaPaciente(Integer id) throws Exception {
        try {
            MySQL.conexion();
            String sql = "SELECT * FROM pacientes WHERE ID=" + id;
            ResultSet result = MySQL.get(sql);
            Paciente pac = new Paciente();
            if (result.next()) {
                pac.setId(result.getInt("id"));
                pac.setNombre(result.getString("nombre"));
                pac.setApellidos(result.getString("apellidos"));
                pac.setTelefono(result.getInt("telefono"));
                pac.setDireccion(result.getString("direccion"));
                pac.setDNI(result.getString("dni"));
                pac.setNSS(result.getString("nss"));
                pac.setSexo(result.getString("sexo"));
                pac.setHospitalId(result.getInt("hospital_id"));
            }
            return pac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Paciente> recuperaPacientes() {

        ArrayList<Paciente> listaPacientes = new ArrayList();
        try {
            MySQL.conexion();
            String sql = "SELECT * FROM pacientes";
            ResultSet rs = MySQL.get(sql);
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setApellidos(rs.getString("apellidos"));
                paciente.setTelefono(rs.getInt("telefono"));
                paciente.setDireccion(rs.getString("direccion"));
                paciente.setDNI(rs.getString("DNI"));
                paciente.setNSS(rs.getString("NSS"));
                paciente.setSexo(rs.getString("sexo"));
                listaPacientes.add(paciente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaPacientes;
    }

    public static void editarPacientes(Paciente paciente) {
        try {
            MySQL.conexion();
            MySQL.updateOne(paciente.getId(), "pacientes", "nombre", paciente.getNombre());
            MySQL.updateOne(paciente.getId(), "pacientes", "apellidos", paciente.getApellidos());
            MySQL.updateOne(paciente.getId(), "pacientes", "telefono", "" + paciente.getTelefono());
            MySQL.updateOne(paciente.getId(), "pacientes", "direccion", "" + paciente.getDireccion());
            MySQL.updateOne(paciente.getId(), "pacientes", "DNI", "" + paciente.getDNI());
            MySQL.updateOne(paciente.getId(), "pacientes", "NSS", "" + paciente.getNSS());
            MySQL.updateOne(paciente.getId(), "pacientes", "sexo", "" + paciente.getSexo());
            MySQL.updateOne(paciente.getId(), "pacientes", "hospital_id", "" + paciente.getHospitalId());
            MySQL.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void altaPacientes(Paciente paciente) {
        try {
            MySQL.conexion();
            Integer id = MySQL.insertOne("pacientes");
            MySQL.updateOne(id, "pacientes", "nombre", paciente.getNombre());
            MySQL.updateOne(id, "pacientes", "apellidos", paciente.getApellidos());
            MySQL.updateOne(id, "pacientes", "telefono", "" + paciente.getTelefono());
            MySQL.updateOne(id, "pacientes", "direccion", "" + paciente.getDireccion());
            MySQL.updateOne(id, "pacientes", "DNI", "" + paciente.getDNI());
            MySQL.updateOne(id, "pacientes", "NSS", "" + paciente.getNSS());
            MySQL.updateOne(id, "pacientes", "sexo", "" + paciente.getSexo());
            MySQL.updateOne(id, "pacientes", "hospital_id", "" + paciente.getHospitalId());
            MySQL.desconexion();
        } catch (Exception ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void bajapacientes(Integer id) {
        try {
            MySQL.conexion();
            MySQL.removeOne(id, "pacientes");
            MySQL.desconexion();
            MySQL.commitTrans();
        } catch (Exception ex) {
            Logger.getLogger(PacienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
