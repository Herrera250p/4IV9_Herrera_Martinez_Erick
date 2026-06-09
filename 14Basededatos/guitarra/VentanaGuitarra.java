import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaGuitarra extends JFrame {

    JTextField txtId;
    JTextField txtMarca;
    JTextField txtModelo;
    JTextField txtTipo;
    JTextField txtAnio;

    JButton btnAgregar;
    JButton btnMostrar;
    JButton btnBuscar;
    JButton btnActualizar;
    JButton btnEliminar;

    JTable tabla;
    DefaultTableModel modelo;

    GuitarraDAO dao = new GuitarraDAO();

    public VentanaGuitarra() {

        setTitle("CRUD Guitarras");
        setSize(900,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        txtId = new JTextField(5);
        txtMarca = new JTextField(10);
        txtModelo = new JTextField(10);
        txtTipo = new JTextField(10);
        txtAnio = new JTextField(5);

        btnAgregar = new JButton("Agregar");
        btnMostrar = new JButton("Mostrar");
        btnBuscar = new JButton("Buscar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");

        add(new JLabel("ID"));
        add(txtId);

        add(new JLabel("Marca"));
        add(txtMarca);

        add(new JLabel("Modelo"));
        add(txtModelo);

        add(new JLabel("Tipo"));
        add(txtTipo);

        add(new JLabel("Año"));
        add(txtAnio);

        add(btnAgregar);
        add(btnMostrar);
        add(btnBuscar);
        add(btnActualizar);
        add(btnEliminar);

        modelo = new DefaultTableModel();

        modelo.addColumn("ID");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Tipo");
        modelo.addColumn("Año");

        tabla = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabla);
        scroll.setPreferredSize(new Dimension(850,350));

        add(scroll);

        btnAgregar.addActionListener(e -> agregar());
        btnMostrar.addActionListener(e -> mostrar());
        btnBuscar.addActionListener(e -> buscar());
        btnActualizar.addActionListener(e -> actualizar());
        btnEliminar.addActionListener(e -> eliminar());

        mostrar();
    }

    private void agregar() {

        try {

            Guitarra g = new Guitarra();

            g.setMarca(txtMarca.getText());
            g.setModelo(txtModelo.getText());
            g.setTipo(txtTipo.getText());
            g.setAnio(Integer.parseInt(txtAnio.getText()));

            dao.insertarGuitarra(g);

            JOptionPane.showMessageDialog(null,
                    "Guitarra agregada");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void mostrar() {

        try {

            modelo.setRowCount(0);

            for(Guitarra g : dao.obtenerGuitarras()) {

                modelo.addRow(new Object[] {
                    g.getId(),
                    g.getMarca(),
                    g.getModelo(),
                    g.getTipo(),
                    g.getAnio()
                });
            }

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void buscar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            int idBuscado =
                    Integer.parseInt(txtId.getText());

            for(Guitarra g : dao.obtenerGuitarras()) {

                if(g.getId() == idBuscado) {

                    txtMarca.setText(g.getMarca());
                    txtModelo.setText(g.getModelo());
                    txtTipo.setText(g.getTipo());
                    txtAnio.setText(
                            String.valueOf(g.getAnio()));

                    return;
                }
            }

            JOptionPane.showMessageDialog(null,
                    "Guitarra no encontrada");

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void actualizar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            Guitarra g = new Guitarra();

            g.setId(Integer.parseInt(txtId.getText()));
            g.setMarca(txtMarca.getText());
            g.setModelo(txtModelo.getText());
            g.setTipo(txtTipo.getText());
            g.setAnio(Integer.parseInt(txtAnio.getText()));

            dao.actualizarGuitarra(g);

            JOptionPane.showMessageDialog(null,
                    "Guitarra actualizada");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void eliminar() {

        try {

            if(txtId.getText().trim().isEmpty()) {

                JOptionPane.showMessageDialog(null,
                        "Ingresa un ID");

                return;
            }

            dao.eliminarGuitarra(
                    Integer.parseInt(txtId.getText()));

            JOptionPane.showMessageDialog(null,
                    "Guitarra eliminada");

            limpiar();

            mostrar();

        } catch(Exception e) {

            JOptionPane.showMessageDialog(null,
                    e.getMessage());

        }
    }

    private void limpiar() {

        txtId.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtTipo.setText("");
        txtAnio.setText("");
    }

    public static void main(String[] args) {

        new VentanaGuitarra().setVisible(true);

    }
}