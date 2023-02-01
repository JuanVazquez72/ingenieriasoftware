import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class SQL extends BD{
     
    public Connection conectarBD() {
        Connection conn = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/prueba","admin","123");
         
            System.out.println("Connected"); 
             
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return conn;
    }
    public void Leer(Connection con){

    }
    public void Escribir(Connection con){
        
    }
    public void Cerrar(Connection con) throws SQLException{

        if (con != null) {
            con.close();
            System.out.println("se cerró");
         }
        
    }
}
