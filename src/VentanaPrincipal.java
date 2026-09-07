
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {
    private JTextField txtTitulo, txtAutor, txtIsbn, txtGenero, txtAnio, txtCopias;
    private JButton btnGuardar;
    private Biblioteca biblioteca; // conexión con la lógica

    public VentanaPrincipal(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;

        setTitle("Registro de Libros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 5, 5));

        add(new JLabel("Título:")); txtTitulo = new JTextField(); add(txtTitulo);
        add(new JLabel("Autor:")); txtAutor = new JTextField(); add(txtAutor);
        add(new JLabel("ISBN / Código:")); txtIsbn = new JTextField(); add(txtIsbn);
        add(new JLabel("Género:")); txtGenero = new JTextField(); add(txtGenero);
        add(new JLabel("Año de publicación:")); txtAnio = new JTextField(); add(txtAnio);
        add(new JLabel("Copias disponibles:")); txtCopias = new JTextField(); add(txtCopias);

        add(new JLabel("")); btnGuardar = new JButton("Guardar Libro"); add(btnGuardar);

        // Acción del botón
        btnGuardar.addActionListener(e -> {
            try {
                String titulo = txtTitulo.getText();
                String autor = txtAutor.getText();
                String isbn = txtIsbn.getText();
                String genero = txtGenero.getText();
                int anio = Integer.parseInt(txtAnio.getText());
                int copias = Integer.parseInt(txtCopias.getText());

                boolean agregado = biblioteca.agregarLibro(titulo, autor, isbn, genero, anio, copias);

                if (agregado) {
                    JOptionPane.showMessageDialog(this, "Libro agregado con éxito");
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(this, "Error: datos inválidos o ISBN duplicado");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Error: Año y copias deben ser números");
            }


        });

    }

    public void limpiarCampos() {
        txtTitulo.setText("");
        txtAutor.setText("");
        txtIsbn.setText("");
        txtGenero.setText("");
        txtAnio.setText("");
        txtCopias.setText("");
    }
}

