import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;
import javax.swing.*;

public class
 Connector {
	public Connection miconexion(String ser, String base, String usu, String contras){
		int b = 0;
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver correcto");
			b=1;
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,e);
		}
		Connection connecion = null;

		if (b == 1)
		{
			try{
				connecion = DriverManager.getConnection("jdbc:mysql://"+ ser + "/" + base + "?serverTimezone=UTC", usu, contras);
				System.out.println("Conexion correcta!");
				JOptionPane.showMessageDialog(null, "Conexion correcta");

				}catch(SQLException s){
					System.out.println(s);
					JOptionPane.showMessageDialog(null,s);
				}
		}
		return connecion;
	}
}
