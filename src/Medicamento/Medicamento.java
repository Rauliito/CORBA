/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medicamento;

import java.sql.*;
import conexion.Conexion;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author jpgas
 */
public class Medicamento extends MedicamentoApp.MedicamentoPOA {
    
    private ORB orb;
    Conexion conectar = new Conexion();

    @Override
    public boolean insertarMedicamento(int id, String nombre, String laboratorio, String descripcion, String composicion, String medicamento) {
        
        boolean resultado = false;
        
        try {
            String sentenciaSql = "insert into medicamento (id, nombre, laboratorio, descripcion, composicion, medicamento)"
                    + "values(" + id + ",'"+ nombre +"','"+ laboratorio +"','"+ descripcion +"','"+ composicion +"','"+ medicamento +"')";
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
    public String consultarMedicamento(int id) {
        String lista = "";
        try{
        String sentenciSql = "Select * from medicamento where id = " + id;
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
    public boolean actualizarMedicamento(int id, String nombre, String laboratorio, String descripcion, String composicion, String medicamento) {
       boolean resultado = false;
        
        try {
            String sentenciaSql = "update medicamento set nombre = '" + nombre + "', laboratorio = '" + laboratorio + "', descripcion='" + descripcion + "', composicion='" + composicion + "', " + "medicamento='" + medicamento + "' where id=" + id;
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
    public boolean eliminarMedicamento(int id) {
        
        boolean resultado = false;
        try{
            String sentenciaSql = "delete from medicamento where id = " + id;
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
    public String listarMedicamento() {
        
        String lista = "";
        try{
            String sentenciSql = "Select * from medicamento";
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
    
     ResultSet cargarTablaMedicamento() {
        ResultSet resultado = null;
        try {
            String query = "Select * from medicamento";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
    
}
