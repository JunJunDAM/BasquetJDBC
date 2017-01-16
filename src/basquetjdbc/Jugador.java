/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquetjdbc;

import java.awt.List;
import java.sql.Date;

/**
 *
 * @author DAM
 */
public class Jugador {
    private String nombre;
    private Date fechaNacimiento;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private String posicion;
    private String equipo;

    public Jugador(String nombre, Date fechaNacimiento, int canastas, int asistencias, int rebotes, String posicion, String equipo) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.posicion = posicion;
        this.equipo = this.equipo;
    }
    
    @Override
    public String toString() {
        return nombre + "{ FechaNacimiento=" + fechaNacimiento + ", canastas=" + canastas + ", asistencias=" + asistencias + ", rebotes=" + rebotes + ", posicion=" + posicion + ", equipo=" + equipo + '}';
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCanastas() {
        return canastas;
    }

    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getRebotes() {
        return rebotes;
    }

    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
    
}
