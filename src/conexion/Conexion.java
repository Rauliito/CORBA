package conexion;

import java.sql.*;

public class Conexion {

    public Connection conex;
    public Conexion() {
        
    }
    
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conex = DriverManager.getConnection("jdbc:mysql://localhost/bd_paciente","root","");
            System.out.println("Se realizó correctamente la conexion.");
        } catch (Exception e) {
            System.out.println("No fue posible la conexion. "+e.getMessage());
        }
        return conex;
    }
}
