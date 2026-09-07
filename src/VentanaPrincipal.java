import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtIsbn;
    private JTextField txtGenero;
    private JTextField txtAnio;
    private JTextField txtCopias;
    private JButton btnGuardar;
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;

    public VentanaPrincipal() {
        setTitle("Sistema de Gestión de Biblioteca");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        String[] columnas = { "Título", "Autor", "ISBN", "Género", "Año", "Copias" };
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaLibros);
        scrollTabla.setPreferredSize(new Dimension(650, 250));

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

        setLayout(new BorderLayout(5, 5));
        add(scrollTabla, BorderLayout.NORTH);
        add(panelFormulario, BorderLayout.CENTER);
    }

    public JTextField getTxtTitulo() { return txtTitulo; }
    public JTextField getTxtAutor() { return txtAutor; }
    public JTextField getTxtIsbn() { return txtIsbn; }
    public JTextField getTxtGenero() { return txtGenero; }
    public JTextField getTxtAnio() { return txtAnio; }
    public JTextField getTxtCopias() { return txtCopias; }
    public JButton getBtnGuardar() { return btnGuardar; }
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
