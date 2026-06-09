import java.sql.*;
import java.util.ArrayList;

public class GuitarraDAO {

    public void insertarGuitarra(Guitarra g) throws Exception {

        Connection con = ConexionBD.getConexion();

        String sql =
        "INSERT INTO Guitarras(marca,modelo,tipo,anio) VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, g.getMarca());
        ps.setString(2, g.getModelo());
        ps.setString(3, g.getTipo());
        ps.setInt(4, g.getAnio());

        ps.executeUpdate();
    }

    public ArrayList<Guitarra> obtenerGuitarras() throws Exception {

        ArrayList<Guitarra> lista = new ArrayList<>();

        Connection con = ConexionBD.getConexion();

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("SELECT * FROM Guitarras");

        while(rs.next()) {

            lista.add(
                new Guitarra(
                    rs.getInt("id_guitarra"),
                    rs.getString("marca"),
                    rs.getString("modelo"),
                    rs.getString("tipo"),
                    rs.getInt("anio")
                )
            );
        }

        return lista;
    }

    public void actualizarGuitarra(Guitarra g) throws Exception {

        Connection con = ConexionBD.getConexion();

        String sql =
        "UPDATE Guitarras SET marca=?,modelo=?,tipo=?,anio=? WHERE id_guitarra=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, g.getMarca());
        ps.setString(2, g.getModelo());
        ps.setString(3, g.getTipo());
        ps.setInt(4, g.getAnio());
        ps.setInt(5, g.getId());

        ps.executeUpdate();
    }

    public void eliminarGuitarra(int id) throws Exception {

        Connection con = ConexionBD.getConexion();

        PreparedStatement ps =
        con.prepareStatement(
        "DELETE FROM Guitarras WHERE id_guitarra=?");

        ps.setInt(1, id);

        ps.executeUpdate();
    }
}
