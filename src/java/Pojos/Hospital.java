/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojos;

/**
 *
 * @author vesprada
 */
public class Hospital {
    private int id;
    private String direccion;
    private String nombre;
    private int telefono;
    private String personal;
    private int salas;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public int getSalas() {
        return salas;
    }

    public void setSalas(int salas) {
        this.salas = salas;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


}
