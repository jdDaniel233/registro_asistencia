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
    
    Connection conectar =null;
    String usuario ="root";
    String contrasenia="root";
    String bd= "registro_asistencia";
    String ip="localhost";
    String puerto="3306";
    
    String cadena ="jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    public Connection estableceConexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        conectar=DriverManager.getConnection(cadena,usuario,contrasenia);
        //JOptionPane.showMessageDialog(null," se conecto a la base de datos ");

    } catch(Exception e){
        JOptionPane.showMessageDialog(null,"No se conecto a la base de datos , error: "+ e.toString());
    }
    return conectar;
    }
    

}
