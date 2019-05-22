/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulamedica;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author jpgas
 */
public class FormulaMedica extends formulamedicaApp.FormulamedicaPOA{
    
    private ORB orb;
    Conexion conectar = new Conexion();

    @Override
    public boolean insertarFormulamedica(int id, String fecha, String dosis, int id_paciente) {
         boolean resultado = false;
        
        try {
            String sentenciaSql = "insert into formulamedica (id, fecha, dosis, id_paciente)"
                    + "values(" + id + ",'"+ fecha +"','"+ dosis +"','"+ id_paciente +"')";
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
    public String consultarFormulamedica(int id) {
        String lista = "";
        try{
        String sentenciSql = "Select * from formulamedica where id = " + id;
        conectar.conectar();
        Statement st = conectar.conex.createStatement();
        ResultSet rs = st.executeQuery(sentenciSql);
        while(rs.next()){
        lista += rs.getLong(2) + " - "
        + rs.getString(3)+ " - "
        + rs.getString(4)+ " - "
        + rs.getLong(5);
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
    public boolean actualizarFormulamedica(int id, String fecha, String dosis, int id_paciente) {
         boolean resultado = false;
        
        try {
            String sentenciaSql = "update formulamedica set fecha = '" + fecha + "', dosis = '" + dosis + "', id_paciente='" + id_paciente +  "' where id=" + id;
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
            JOptionPane.showMessageDialog(null, "Ocurrio un error al actualizar la formula medica. " + e.getMessage());
        }
        return resultado;
    }

    @Override
    public boolean eliminarFormulamedica(int id) {
       boolean resultado = false;
        try{
            String sentenciaSql = "delete from formulamedica where id = " + id;
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
    public String listarFormulamedica() {
        String lista = "";
        try{
            String sentenciSql = "Select * from formulamedica";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            ResultSet rs = st.executeQuery(sentenciSql);
            while(rs.next()){
                lista += rs.getLong(2) + " - " 
                        + rs.getString(3)+ " - " 
                        + rs.getString(4)+ " - " 
                        + rs.getLong(5);
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
    
    ResultSet cargarTablaFormulaMedica() {
        ResultSet resultado = null;
        try {
            String query = "Select * from formulamedica";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
   
    
}
