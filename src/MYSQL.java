import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class MYSQL extends BD{
    
   // public void  Conectarse(){
     //   try
       // {
         //   Class.forName("com.mysql.jdbc.Driver");
           // Connection con =DriverManager.getConnection(
             //       "jdbc:mysql://localhost:3306/prueba","admin","123");
         //
           // System.out.println("Connected"); 
             
           
       // }
        //catch(Exception e)
       // {
         //   System.out.println(e);
        //}
    
   
        
   // }

    public Connection conectarBD() {
        Connection conn = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn =DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/prueba","root","Holaamigos123");
         
            System.out.println("Connected"); 
             
           
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        return conn;
    }

   


    public void Leer(Connection con){
        Statement consulta = null;
        ResultSet rs;
        try {
            consulta = con.createStatement();
            
            rs = consulta.executeQuery("SELECT * FROM alumnos");
            int i = 1;
            

            while(rs.next()){
                String a = rs.getString(i);
                System.out.println("nombre: "+a+ " columna: " +rs.getRow());
               


            }



            

         

        } catch (Exception e) {
            
            System.out.println(e);
        }

       
        

    }
    public void Escribir(Connection con){
 
      Statement consulta = null;
        
        try {

            consulta = con.createStatement();
            String ra = "INSERT INTO carreras " + "VALUES (202, 'Mate', 'sumar')";
            consulta.executeUpdate(ra);

            System.out.println("Registro agregado");

        } catch (Exception e) {
            
            System.out.println(e);
        }

       
        





    }
    public void Cerrar(Connection con) throws SQLException{

        if (con != null) {
            con.close();
            System.out.println("se cerró");
         }
         
    }
}