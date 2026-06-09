
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;

/*
 * ============================================================================
 * CAPA: CONTROLADOR — ProductoControlador
 * ============================================================================
 *
 * PATRÓN MVC — ¿QUÉ ES EL CONTROLADOR?
 * El Controlador es el INTERMEDIARIO entre la Vista y el Modelo.
 * Recibe los EVENTOS del usuario (clics, selecciones) desde la Vista,
 * ejecuta la LÓGICA correspondiente usando el Modelo, y actualiza la Vista
 * con los resultados.
 *
 * RESPONSABILIDADES DEL CONTROLADOR:
 *   1. Escuchar eventos de la Vista (botones, tabla, combo box)
 *   2. Leer datos del formulario de la Vista
 *   3. Validar datos antes de enviarlos al Modelo
 *   4. Llamar al Modelo (DAO) para operaciones CRUD
 *   5. Actualizar la Vista con el resultado (tabla, mensajes)
 *   6. Manejar errores y mostrar mensajes apropiados
 *
 * CAMBIO RESPECTO A PRÁCTICA 2:
 * En Práctica 2, toda esta lógica estaba DENTRO de VentanaPrincipal.
 * Los métodos accionAgregar(), accionActualizar(), etc. vivían en la Vista.
 * Ahora están aquí, en su propio lugar.
 *
 * FLUJO COMPLETO:
 *
 *   1. Usuario hace clic en "Agregar" (evento en la VISTA)
 *   2. El CONTROLADOR captura el evento (ActionListener)
 *   3. El CONTROLADOR lee los datos del formulario (desde la VISTA)
 *   4. El CONTROLADOR construye un objeto Producto (MODELO)
 *   5. El CONTROLADOR llama a dao.agregar() (MODELO)
 *   6. El CONTROLADOR actualiza la tabla (VISTA)
 *   7. El CONTROLADOR muestra mensaje de éxito (VISTA)
 *
 * ¿POR QUÉ SEPARAR?
 *   - Si cambiamos la GUI (ej: de Swing a JavaFX), el Controlador se adapta
 *     pero el Modelo NO cambia.
 *   - Si cambiamos la BD (ej: de MySQL a PostgreSQL), el Modelo se adapta
 *     pero la Vista y el Controlador NO cambian.
 *   - Más fácil de mantener, probar y extender.
 * ============================================================================
 */
public class ProductoControlador {

    // Referencias a las otras dos capas
// VISTA — interfaz gráfica
    GuitarraDAO guitarraDAO;
    CancionDAO cancionDAO;
    AccesorioDAO accesorioDAO;
    ProductoVista vista;
    /*
     * CONSTRUCTOR:
     * Recibe el Modelo (DAO) y la Vista como parámetros.
     * El Controlador no CREA ni el Modelo ni la Vista, solo los CONECTA.
     * Esto se llama INYECCIÓN DE DEPENDENCIAS — las dependencias se
     * pasan desde afuera (Main) en lugar de crearlas internamente.
     */
public ProductoControlador(ProductoVista vista) {

    this.vista = vista;

    guitarraDAO = new GuitarraDAO();
    cancionDAO = new CancionDAO();
    accesorioDAO = new AccesorioDAO();

    inicializarEventos();
}

    /*
     * ========================================================================
     * REGISTRO DE EVENTOS
     * ========================================================================
     *
     * Aquí conectamos cada botón de la VISTA con su acción en el CONTROLADOR.
     * La Vista no sabe qué hará cada botón. El Controlador lo decide.
     *
     * COMPARACIÓN CON PRÁCTICA 2:
     * Antes:  btnAgregar.addActionListener(e -> accionAgregar());  // DENTRO de la Vista
     * Ahora:  vista.getBtnAgregar().addActionListener(e -> agregar()); // FUERA de la Vista
     *
     * La Vista solo expone los botones. El Controlador les da comportamiento.
     * ========================================================================
     */
    private void inicializarEventos() {
        // Botones CRUD
        vista.getBtnAgregar().addActionListener(e -> agregar());
        vista.getBtnActualizar().addActionListener(e -> actualizar());
        vista.getBtnEliminar().addActionListener(e -> eliminar());
        vista.getBtnBuscar().addActionListener(e -> buscar());
        vista.getBtnLimpiar().addActionListener(e -> vista.limpiarFormulario());

        // Cambio de tipo de producto (muestra/oculta campos específicos)
        vista.getCmbTipoElemento().addActionListener(e -> cambiarCamposEspecificos());

        // Clic en fila de la tabla → cargar datos en formulario
        vista.getTablaProductos().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cargarProductoSeleccionado();
            }
        });
    }

    // ========================================================================
    // ACCIONES CRUD — la lógica que antes estaba en VentanaPrincipal
    // ========================================================================

    /*
     * AGREGAR:
     * 1. Lee datos del formulario (Vista)
     * 2. Construye objeto Producto (Modelo)
     * 3. Llama al DAO para guardar (Modelo)
     * 4. Actualiza tabla y muestra mensaje (Vista)
     */
    private void agregar() {

    try {

        String tipo =
            (String) vista.getCmbTipoElemento()
                          .getSelectedItem();

        int id =
            Integer.parseInt(
                vista.getTxtId().getText()
            );

        switch(tipo){

            case "GUITARRA":

                Guitarra g = new Guitarra(
                        id,
                        vista.getTxtMarca().getText(),
                        vista.getTxtMarca().getText(),
                        vista.getTxtModelo().getText(),
                        vista.getTxtTipo().getText(),
                        vista.getTxtColor().getText(),
                        Double.parseDouble(
                                vista.getTxtPrecio().getText())
                );

                guitarraDAO.agregar(g);

                break;

            case "CANCION":

                Cancion c = new Cancion(
                        id,
                        vista.getTxtNombre().getText(),
                        vista.getTxtArtista().getText(),
                        vista.getTxtGenero().getText(),
                        vista.getTxtDificultad().getText(),
                        Integer.parseInt(
                                vista.getTxtDuracion().getText())
                );

                cancionDAO.agregar(c);

                break;

            case "ACCESORIO":

                Accesorio a = new Accesorio(
                        id,
                        vista.getTxtNombreAcc().getText(),
                        vista.getTxtMarcaAcc().getText(),
                        vista.getTxtTipoAcc().getText(),
                        Double.parseDouble(
                                vista.getTxtPrecioAcc().getText()),
                        Integer.parseInt(
                                vista.getTxtStock().getText())
                );

                accesorioDAO.agregar(a);

                break;
        }

        vista.mostrarMensaje("Registro agregado");
        vista.limpiarFormulario();

    } catch(Exception ex){

        vista.mostrarError(ex.getMessage());
    }
}
    private void actualizar() {
        var tipo = "";
        switch(tipo){

    case "GUITARRA":
        guitarraDAO.actualizar(g);
        break;

    case "CANCION":
        cancionDAO.actualizar(c);
        break;

    case "ACCESORIO":
        accesorioDAO.actualizar(a);
        break;
}
        try {
            Producto producto = construirProductoDesdeFormulario();
            if (producto == null) return;

            dao.actualizar(producto);
            cargarTabla();
            vista.limpiarFormulario();
            vista.mostrarMensaje("Producto actualizado exitosamente.");
        } catch (NumberFormatException ex) {
            vista.mostrarError("Verifique que los campos numéricos sean válidos.");
        } catch (SQLException ex) {
            vista.mostrarError("Error al actualizar: " + ex.getMessage());
        }
    }

private void eliminar() {

    try {

        int id =
            Integer.parseInt(
                vista.getTxtId().getText());

        String tipo =
            (String) vista.getCmbTipoElemento()
                          .getSelectedItem();

        switch(tipo){

            case "GUITARRA":
                guitarraDAO.eliminar(id);
                break;

            case "CANCION":
                cancionDAO.eliminar(id);
                break;

            case "ACCESORIO":
                accesorioDAO.eliminar(id);
                break;
        }

        vista.mostrarMensaje("Registro eliminado");

    } catch(Exception ex){

        vista.mostrarError(ex.getMessage());
    }
}

    private void buscar() {
        String idStr = vista.getTxtId().getText().trim();
        if (idStr.isEmpty()) {
            vista.mostrarError("Ingrese el ID del producto a buscar.");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            Producto producto = dao.buscarPorId(id);

            if (producto != null) {
                cargarProductoEnFormulario(producto);
                vista.mostrarMensaje("Producto encontrado:\n" + producto.mostrarDetalle());
            } else {
                vista.mostrarError("No se encontró un producto con ID " + id);
            }
        } catch (SQLException ex) {
            vista.mostrarError("Error al buscar: " + ex.getMessage());
        }
    }

    // ========================================================================
    // MÉTODOS AUXILIARES
    // ========================================================================

    // Cambia los campos específicos según el tipo seleccionado
  private void cambiarCamposEspecificos() {

    String tipo =
        (String) vista.getCmbTipoElemento().getSelectedItem();

    vista.getCardLayout().show(
            vista.getPanelCamposEspecificos(),
            tipo);
}

    /*
     * Lee datos de la VISTA y construye un objeto del MODELO.
     * Este método es el PUENTE entre Vista y Modelo:
     * toma datos visuales y los convierte en objetos de negocio.
     */
    
}