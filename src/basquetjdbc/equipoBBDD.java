/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquetjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DAM
 */
public class equipoBBDD {
    
    private Connection conexion;
    
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
    
    
}
