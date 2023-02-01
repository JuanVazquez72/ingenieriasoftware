import java.sql.Connection;
import java.sql.*;


public abstract class BD {
    //public abstract void Conectarse();
    public abstract void Leer(Connection con);
    public abstract void Escribir(Connection con);
    public abstract Connection conectarBD();
    public abstract void Cerrar(Connection con) throws SQLException;
}
