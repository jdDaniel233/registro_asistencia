/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.control_asistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class Conexion {
    
    Connection conectar = null ;
    String usuario ="root";
    String contraseña ="root";
    String bd ="proyecto";
    String ip = "localhost";
    String puerto ="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
    public Connection estableceConeccion(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection(cadena ,usuario,contraseña);
            
        
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"no se pudo conectar" + e.toString() );
        
        }
        return conectar;
    
    
    
    }
    
    
    
    
    
    

}
