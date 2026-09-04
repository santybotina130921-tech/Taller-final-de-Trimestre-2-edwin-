import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class VentanaPrincipal extends JFrame {

    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtIsbn;
    private JTextField txtGenero;
    private JTextField txtAnio;
    private JTextField txtCopias;
    private JButton btnGuardar;

    public VentanaPrincipal() {
        setTitle("Registro de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel("ISBN / Código:"));
        txtIsbn = new JTextField();
        add(txtIsbn);

        add(new JLabel("Género:"));
        txtGenero = new JTextField();
        add(txtGenero);

        add(new JLabel("Año de publicación:"));
        txtAnio = new JTextField();
        add(txtAnio);

        add(new JLabel("Copias disponibles:"));
        txtCopias = new JTextField();
        add(txtCopias);

        add(new JLabel(""));
        btnGuardar = new JButton("Guardar Libro");
        add(btnGuardar);
    }

    public JTextField getTxtTitulo() { return txtTitulo; }
    public JTextField getTxtAutor() { return txtAutor; }
    public JTextField getTxtIsbn() { return txtIsbn; }
    public JTextField getTxtGenero() { return txtGenero; }
    public JTextField getTxtAnio() { return txtAnio; }
    public JTextField getTxtCopias() { return txtCopias; }
    public JButton getBtnGuardar() { return btnGuardar; }

    public void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }
}
