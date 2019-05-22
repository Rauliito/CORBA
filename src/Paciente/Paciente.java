/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paciente;

import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

public class Paciente extends PacienteApp.PacientePOA {

        
    private ORB orb;
    Conexion conectar = new Conexion();
    
    @Override
    public boolean insertarPaciente(int id, String nombre, String apellido, String identificacion, String telefono, String direccion) {
        
        boolean resultado = false;
        
        try {
            String sentenciaSql = "insert into paciente (id, nombre, apellido, identificacion, telefono, direccion)"
                    + "values(" + id + ",'"+ nombre +"','"+ apellido +"','"+ identificacion +"','"+ telefono +"','"+ direccion +"')";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al insertar una nueva persona. " + e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public String consultarPaciente(int id) {
        String lista = "";
        try{
            String sentenciSql = "Select * from paciente where id = " + id;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
        while(rs.next()){
            lista += rs.getString(2) + " - "
            + rs.getString(3)+ " - "
            + rs.getString(4)+ " - "
            + rs.getString(5)+ " - "
            + rs.getString(6);
        }
        //Se cierran los recursos.
        rs.close();
        conectar.conex.close();
        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return lista;
    }

    @Override
    public boolean actualizarPaciente(int id, String nombre, String apellido, String identificacion, String telefono, String direccion) {
        boolean resultado = false;
        
        try {
            String sentenciaSql = "update paciente set nombre = '" + nombre + "', apellido = '" + apellido + "', identificacion='" + identificacion + "', telefono='" + telefono + "', " + "direccion='" + direccion + "' where id=" + id;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la persona. " + e.getMessage());
        }
        return resultado;
        
    }

    @Override
    public boolean eliminarPaciente(int id) {
      boolean resultado = false;
        try{
            String sentenciaSql = "delete from paciente where id = " + id;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            int valor = st.executeUpdate(sentenciaSql);
            if(valor > 0){
                resultado = true;
            }
            //Se cierran los recursos
            st.close();
            conectar.conex.close();

        }catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return resultado;
     
    }
    
    

    @Override
    public String listarPaciente() {
       
         String lista = "";
        try{
            String sentenciSql = "Select * from paciente";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) + " - " 
                        + rs.getString(3)+ " - " 
                        + rs.getString(4)+ " - " 
                        + rs.getString(5)+ " - " 
                        + rs.getString(6);
            }
            //Se cierran los recursos.
            rs.close();
            conectar.conex.close();
            
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ocurrio un error en el catch: " + ex.getMessage());
        }
        return lista;
        
        
        
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /*
    ResultSet cargarComboPacientes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    ResultSet cargarTablaPaciente() {
        ResultSet resultado = null;
        try {
            String query = "Select * from paciente";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }

    /*
    boolean insertarPaciente(Object object, String nombres, String apellidos, String direccion, String telefono, String direccion0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
}
