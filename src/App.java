import java.sql.*;

public class App {
    public static void main(String[] args) throws Exception {
        
        MYSQL base1 = new MYSQL();
        //SQL base2 = new SQL();

        
       Connection conexiónbase1 =base1.conectarBD();
       base1.Leer(conexiónbase1);
       //base1.Escribir(conexiónbase1);
       //base1.Cerrar(conexiónbase1);
       //base2.conectarBD();
       
       
        
    }
}
