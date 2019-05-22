/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diagnostico;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author jpgas
 */

public class Diagnostico extends DiagnosticoApp.DiagnosticoPOA {
    
    private ORB orb;
    Conexion conectar = new Conexion();
    
    @Override
    public boolean insertarDiagnostico(int id, String nombre, String descripcion, int id_paciente) {
      boolean resultado = false;
        
        try {
            String sentenciaSql = "insert into diagnostico (id, nombre, descripcion, id_paciente)"
                    + "values(" + id + ",'"+ nombre +"','"+ descripcion +"','"+ id_paciente +"')";
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
    public String consultarDiagnostico(int id) {
        String lista = "";
        try{
            String sentenciSql = "Select * from diagnostico where id = " + id;
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
        while(rs.next()){
            lista += rs.getString(2) + " - "
            + rs.getString(3)+ " - "
            + rs.getString(4);
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
    public boolean actualizarDiagnostico(int id, String nombre, String descripcion, int id_paciente) {
        boolean resultado = false;
        
        try {
            String sentenciaSql = "update diagnostico set nombre = '" + nombre + "', descripcion = '" + descripcion + "', id_paciente='" + id_paciente +  "' where id=" + id;
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
    public boolean eliminarDiagnostico(int id) {
         boolean resultado = false;
        try{
            String sentenciaSql = "delete from diagnostico where id = " + id;
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
    public String listarDiagnostico() {
        String lista = "";
        try{
            String sentenciSql = "Select * from diagnostico";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) + " - " 
                        + rs.getString(3)+ " - " 
                        + rs.getString(4);
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
    
    ResultSet cargarTablaDiagnostico() {
        ResultSet resultado = null;
        try {
            String query = "Select * from diagnostico";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
