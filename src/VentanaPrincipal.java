import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 550);
        setLocationRelativeTo(null);

        String[] columnas = { "Título", "Autor", "ISBN", "Género", "Año", "Copias" };
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

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String isbn = txtIsbn.getText();
                String genero = txtGenero.getText();
                String anio = txtAnio.getText();
                String copias = txtCopias.getText();

                modeloTabla.addRow(new Object[]{titulo, autor, isbn, genero, anio, copias});
                limpiarCampos();
            }
        });

        btnFiltrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String buscar = txtBuscarAutor.getText().toLowerCase();
                if (buscar.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Escribe algo para filtrar");
                    return;
                }
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    boolean visible = false;
                    for (int j = 0; j < modeloTabla.getColumnCount(); j++) {
                        Object valor = modeloTabla.getValueAt(i, j);
                        if (valor != null && valor.toString().toLowerCase().contains(buscar)) {
                            visible = true;
                            break;
                        }
                    }
                    tablaLibros.setRowHeight(i, visible ? 25 : 0);
                }
            }
        });

        btnMostrarTodos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                    tablaLibros.setRowHeight(i, 25);
                }
                txtBuscarAutor.setText("");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int fila = tablaLibros.getSelectedRow();
                if (fila >= 0) {
                    modeloTabla.removeRow(fila);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un libro de la tabla");
                }
            }
        });
    }

    public JTextField getTxtTitulo() { return txtTitulo; }
    public JTextField getTxtAutor() { return txtAutor; }
    public JTextField getTxtIsbn() { return txtIsbn; }
    public JTextField getTxtGenero() { return txtGenero; }
    public JTextField getTxtAnio() { return txtAnio; }
    public JTextField getTxtCopias() { return txtCopias; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JTextField getTxtBuscarAutor() { return txtBuscarAutor; }
    public JButton getBtnFiltrar() { return btnFiltrar; }
    public JButton getBtnEliminar() { return btnEliminar; }
    public JTable getTablaLibros() { return tablaLibros; }
    public DefaultTableModel getModeloTabla() { return modeloTabla; }

    public void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }
}
