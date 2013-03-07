/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author ACE
 */
public class Habitacion {
    private Integer id;
    private Integer numero;
    private Integer telefono;
    private Integer hospitalId;

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }                            
}
