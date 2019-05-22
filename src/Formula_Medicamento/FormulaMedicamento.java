/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formula_Medicamento;

import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.omg.CORBA.ORB;

/**
 *
 * @author jpgas
 */
public class FormulaMedicamento extends formula_medicamentoApp.Formula_MedicamentoPOA{

    
    private ORB orb;
    Conexion conectar = new Conexion();
        
    @Override
    public boolean insertarFormula_Medicamento(int id, int id_formula, String cantidad, int id_medicamento) {
         boolean resultado = false;
        
        try {
            String sentenciaSql = "insert into formula_medicamento (id, id_formula, cantidad, id_medicamento)"
                    + "values(" + id + ",'"+ id_formula +"','"+ cantidad +"','"+ id_medicamento +"')";
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
    public String consultarFormula_Medicamento(int id) {
        String lista = "";
        try{
            String sentenciSql = "Select * from formula_medicamento where id = " + id;
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
    public boolean actualizarFormula_Medicamento(int id, int id_formula, String cantidad, int id_medicamento) {
        boolean resultado = false;
        
        try {
            String sentenciaSql = "update formula_medicamento set id_formula = '" + id_formula + "', cantidad = '" + cantidad + "', id_medicamento='" + id_medicamento + "' where id=" + id;
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
    public boolean eliminarFormula_Medicamento(int id) {
        boolean resultado = false;
        try{
            String sentenciaSql = "delete from formula_medicamento where id = " + id;
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
    public String listarFormula_Medicamento() {
        String lista = "";
        try{
            String sentenciSql = "Select * from formula_medicamento";
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
    
    ResultSet cargarTablaFormulaMedicamento() {
        ResultSet resultado = null;
        try {
            String query = "Select * from formula_medicamento";
            conectar.conectar();
            Statement st = conectar.conex.createStatement();
            resultado = st.executeQuery(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: "+e.getMessage());
        }
        return resultado;
    }
    
}
