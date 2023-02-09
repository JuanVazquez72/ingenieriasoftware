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

    public String selecionar(String Selecionar){
		Connector Connectador = new Connector(); 
		Connection con = Connectador.miconexion("localhost:3306","testing1","root","testing123!");
		try{
				/*jdbc es java data base conection, pones el hoast en nuestro caso es el local
				pones el puerto y al final el nombre de la base de datos luego , usuario , contra*/
				String querry = "select * from "+ Selecionar;
				System.out.println(querry);
				//creo que este se encarga de los querrys
				Statement st = con.createStatement();
				// result set tiene el conjunto de resultados de un mysql queryy
				ResultSet rs = st.executeQuery(querry);
				while (rs.next()){
					int id = rs.getInt("cod_comida");
					//System.out.println(id);
					String nombre = rs.getString("nombre");
					//System.out.println(nombre);
					Date dateCreated = rs.getDate("fecha");
					Time timeCreated = rs.getTime("tiempo");
				System.out.println(id+nombre+dateCreated+timeCreated);
				}
				con.close();
			}catch(Exception ex){
				System.out.println(ex);
			}
			return "terminado";
		}
}