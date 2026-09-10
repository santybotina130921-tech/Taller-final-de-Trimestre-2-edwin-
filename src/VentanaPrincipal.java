import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtIsbn;
    private JTextField txtGenero;
    private JTextField txtAnio;
    private JTextField txtCopias;
    private JButton btnGuardar;
    private JTextField txtBuscarAutor;
    private JButton btnFiltrar;
    private JButton btnEliminar;
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;
    private Biblioteca biblioteca;  // conexión con la lógica

    public VentanaPrincipal() {
        biblioteca = new Biblioteca(); // CAMBIO: conexión con la lógica
        setTitle("Sistema de Gestión de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);

        String[] columnas = {"Título", "Autor", "ISBN", "Género", "Año", "Copias"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        scrollTabla.setPreferredSize(new Dimension(650, 200));

        JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltro.add(new JLabel("Buscar por autor:"));
        txtBuscarAutor = new JTextField(20);
        panelFiltro.add(txtBuscarAutor);
        btnFiltrar = new JButton("Filtrar");
        panelFiltro.add(btnFiltrar);
        JButton btnMostrarTodos = new JButton("Mostrar Todos");
        panelFiltro.add(btnMostrarTodos);

        JPanel panelFormulario = new JPanel(new GridLayout(7, 2, 5, 5));

        panelFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("ISBN / Código:"));
        txtIsbn = new JTextField();
        panelFormulario.add(txtIsbn);

        panelFormulario.add(new JLabel("Género:"));
        txtGenero = new JTextField();
        panelFormulario.add(txtGenero);

        panelFormulario.add(new JLabel("Año de publicación:"));
        txtAnio = new JTextField();
        panelFormulario.add(txtAnio);

        panelFormulario.add(new JLabel("Copias disponibles:"));
        txtCopias = new JTextField();
        panelFormulario.add(txtCopias);

        panelFormulario.add(new JLabel(""));
        btnGuardar = new JButton("Guardar Libro");
        panelFormulario.add(btnGuardar);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnEliminar = new JButton("Eliminar Libro");
        panelBotones.add(btnEliminar);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.add(scrollTabla, BorderLayout.NORTH);
        panelSuperior.add(panelFiltro, BorderLayout.SOUTH);

        setLayout(new BorderLayout(5, 5));
        add(panelSuperior, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        //  solo un listener para Guardar
        btnGuardar.addActionListener(this::actionPerformed);

        //  Filtrar usando biblioteca
        btnFiltrar.addActionListener(e -> {
            String autor = txtBuscarAutor.getText().trim();
            actualizarTabla(biblioteca.filtrarPorAutor(autor));
        });

        //  Mostrar todos usando biblioteca
        btnMostrarTodos.addActionListener(e -> {
            actualizarTabla(biblioteca.obtenerTodos());
            txtBuscarAutor.setText("");
        });

        //  Eliminar conectado con biblioteca
        btnEliminar.addActionListener(e -> {
            int fila = tablaLibros.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(this, "Selecciona un libro de la tabla");
                return;
            }
            String isbn = (String) modeloTabla.getValueAt(fila, 2);
            int confirm = JOptionPane.showConfirmDialog(
                    this,
                    "¿Seguro que quieres eliminar el libro con ISBN " + isbn + "?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirm == JOptionPane.YES_OPTION) {
                biblioteca.eliminarLibro(isbn);
                actualizarTabla(biblioteca.obtenerTodos());
            }
        });
    }

    // limpia
    public void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }

    // CAMBIO: Guardar conectado con biblioteca
    private void actionPerformed(ActionEvent e) {
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String isbn = txtIsbn.getText();
        String genero = txtGenero.getText();
        int anio = Integer.parseInt(txtAnio.getText());
        int copias = Integer.parseInt(txtCopias.getText());

        if (biblioteca.agregarLibro(titulo, autor, isbn, genero, anio, copias)) {
            JOptionPane.showMessageDialog(this, "Libro agregado con éxito");
            limpiarCampos();
            actualizarTabla(biblioteca.obtenerTodos()); // refresca la tabla
        } else {
            JOptionPane.showMessageDialog(this, "Error: ISBN duplicado");
        }
    }

    // CAMBIO: método para sincronizar tabla con biblioteca
    private void actualizarTabla(ArrayList<Libro> libros) {
        DefaultTableModel modelo = (DefaultTableModel) tablaLibros.getModel();
        modelo.setRowCount(0); // limpia todas las filas

        for (Libro libro : libros) {
            modelo.addRow(new Object[]{
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getIsbn(),
                    libro.getGenero(),
                    libro.getAño(), // CAMBIO: usar "anio" en lugar de "año"
                    libro.getCopiasDisponibles()
            });
        }
    }
}
