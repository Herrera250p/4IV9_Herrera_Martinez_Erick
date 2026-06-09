

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GuitarraDAO {

    public void agregar(Guitarra g) throws Exception {

        String sql = """
            INSERT INTO guitarras
            (id_guitarra, marca, modelo, tipo, color, precio)
            VALUES (?, ?, ?, ?, ?, ?)
        """;

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, g.getId());
            ps.setString(3, g.getModelo());
            ps.setString(4, g.getTipo());
            ps.setString(5, g.getColor());
            ps.setDouble(6, g.getPrecio());

            ps.executeUpdate();
        }
    }

    public Guitarra buscarPorId(int id) throws Exception {

        String sql =
            "SELECT * FROM guitarras WHERE id_guitarra = ?";

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                return new Guitarra(
                    rs.getInt("id_guitarra"),
                    rs.getString("modelo"),
                    rs.getString("tipo"),
                    rs.getString("color"),
                    rs.getDouble("precio")
                );
            }
        }

        return null;
    }

    public List<Guitarra> listarTodos() throws Exception {

        List<Guitarra> lista = new ArrayList<>();

        String sql = "SELECT * FROM guitarras";

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {

            while(rs.next()) {

                lista.add(
                    new Guitarra(
                        rs.getInt("id_guitarra"),
                        rs.getString("modelo"),
                        rs.getString("tipo"),
                        rs.getString("color"),
                        rs.getDouble("precio")
                    )
                );
            }
        }

        return lista;
    }

    public void actualizar(Guitarra g) throws Exception {

        String sql = """
            UPDATE guitarras
            SET marca=?,
                modelo=?,
                tipo=?,
                color=?,
                precio=?
            WHERE id_guitarra=?
        """;

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(2, g.getModelo());
            ps.setString(3, g.getTipo());
            ps.setString(4, g.getColor());
            ps.setDouble(5, g.getPrecio());
            ps.setInt(6, g.getId());

            ps.executeUpdate();
        }
    }

    public void eliminar(int id) throws Exception {

        String sql =
            "DELETE FROM guitarras WHERE id_guitarra=?";

        try(Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }
}