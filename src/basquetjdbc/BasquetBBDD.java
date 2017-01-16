/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquetjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DAM
 */
public class BasquetBBDD {
    
    private Connection conexion;
    
    BasquetBBDD(){
        
    }
    
    private void conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/BasquetJDBC";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }
    
    private void desconectar() throws SQLException{
        if(conexion != null){
            conexion.close();
        }
    }
    
    public void instertarJugadorBD(Jugador j) throws SQLException{
        conectar();
        String insert = "INSERT INTO Jugadores values (?,?,?,?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, j.getNombre());
        ps.setDate(2, j.getFechaNacimiento());
        ps.setInt(3, j.getCanastas());
        ps.setInt(4, j.getAsistencias());
        ps.setInt(5, j.getRebotes());
        ps.setString(6, j.getPosicion());
        ps.setString(7, j.getEquipo());
        ps.executeUpdate();
        ps.close();
        desconectar();
    }
    
    public void insertarEquipoBD(Equipo e) throws SQLException{
        conectar();
        String insert = "INSERT INTO Equipos values (?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);
        ps.setString(1, e.getNombre());
        ps.setDate(2, e.getFechaCreacion());
        ps.setString(3, e.getCiudad());
        ps.executeUpdate();
        ps.close();
        desconectar();
    }
}
