/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;

import com.mycompany.control_asistencia.Conexion;
import java.awt.HeadlessException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author ASUS
 */
public class RDocentes {
    private String codigo;
    
    private String descripcion;

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    String cedula;
    String nombre;
    String apellido;
    String direccion;
    String telefono;
    String nacimiento;
    String carrera;
    
    
    
    public void comboCarrera(String valor, JComboBox combo) {
        String sql = "call sp_carrera_select();" ;
        Statement st;
        Conexion con =new Conexion();
        Connection conexion =con.estableceConexion();
        
        try {
            st=conexion.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
            combo.addItem(rs.getString(valor ));
                    //.getString(valor));
            
            }
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR" + ex.toString());
        }
    }
    
    public void InsertarDocente(JComboBox combo,JTextField paramCedula, JTextField paramNombre, JTextField paramApellido, JTextField paramDireccion, JTextField paramTelefono, JTextField paramNacimiento){
       setCedula(paramCedula.getText());
       setNombre(paramNombre.getText());
       setApellido(paramApellido.getText());
       setDireccion(paramDireccion.getText());
       setNacimiento(paramNacimiento.getText());
       setTelefono(paramTelefono.getText());
       
       setCarrera(combo.getSelectedItem().toString());
       
       Conexion con = new Conexion();
       
        
        String consulta="call sp_docentes_insert(?,?,?,?,?,?,?);";
        
        try{
            CallableStatement cs = con.estableceConexion().prepareCall(consulta);
            cs.setString(1,getCedula());
            cs.setString(2,getNombre());
            cs.setString(3,getApellido());
            cs.setString(4,getDireccion());
            cs.setString(5,getNacimiento());
            cs.setString(6,getTelefono());
            cs.setString(7,getCarrera());
                
            cs.execute();
            
            JOptionPane.showMessageDialog(null,"SE INSERTO CORRECTAMENTE EL USUARIO");
            
        }catch (HeadlessException | SQLException e){ 
            JOptionPane.showMessageDialog(null,"NO SE INSERTO CORRECTAMENTE EL USUARIO" + e.toString());
        }
    
    }

    public void Insertar(JTextField txtCedula, JTextField txtNombre, JTextField txtApellido, JTextField txtDireccion, JTextField txtNacimiento, JTextField txtTelefono, JComboBox<String> comboCarrera) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    Conexion con = new Conexion();
    
    public RDocentes(String codigo,String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    
    }
    
    public RDocentes(){
        
    
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    public void llenar_combo(JComboBox<RDocentes> comboCarreras){
        try{
            String sql="call sp_carrera_select();";
            Statement st;
          Conexion cone =new Conexion();
          Connection conexion =cone.estableceConexion();
            //con.sentencia= con.estableceConexion().createStatement();
            //con.rs=con.consultar(sql);
            st=conexion.createStatement();
            ResultSet rs =st.executeQuery(sql);
            comboCarreras.removeAllItems();
            while(rs.next()){
                comboCarreras.addItem(new RDocentes( 
                        rs.getString("car_id"),
                        rs.getString("car_nombre") ));
            }
        
        }catch(SQLException ex){
            Logger.getLogger(RDocentes.class.getName()).log(Level.SEVERE,null,ex);
            
        
        }
    }
    @Override
    public String toString(){
    return  descripcion;
    }  
}
