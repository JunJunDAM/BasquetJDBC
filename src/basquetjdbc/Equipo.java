/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquetjdbc;

import java.sql.Date;

/**
 *
 * @author DAM
 */
public class Equipo {
    private String nombre;
    private String ciudad;
    private Date fechaCreacion;

    public Equipo(String nombre, String ciudad, Date fechaCreacion) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return nombre + "{ Ciudad=" + ciudad + ", fechaCreacion=" + fechaCreacion + '}';
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
}
