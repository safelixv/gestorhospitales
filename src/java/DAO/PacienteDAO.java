/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Pojos.Paciente;
import java.util.ArrayList;

/**
 *
 * @author ACE
 */
public interface PacienteDAO {

    void altaPacientes(Paciente paciente);

    void bajapacientes(Integer id);

    void editarPacientes(Paciente paciente);

    Paciente recuperaPaciente(Integer id) throws Exception;

    ArrayList<Paciente> recuperaPacientes();
    
}
