import javax.swing.SwingUtilities;

public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    });
}

