import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/guitarra?serverTimezone=America/Mexico_City";

    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexion() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(URL, USER, PASS);
    }
}