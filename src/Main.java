import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        Biblioteca miBiblioteca = new Biblioteca();

        // Pruebas en consola
        boolean res1 = miBiblioteca.agregarLibro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728", "Novela", 1967, 5);
        boolean res2 = miBiblioteca.agregarLibro("El coronel no tiene quien le escriba", "Gabriel García Márquez", "978-9588939775", "Novela", 1961, 3);

        System.out.println("¿Libro 1 agregado? " + res1);
        System.out.println("¿Libro 2 agregado? " + res2);

        boolean resDuplicado = miBiblioteca.agregarLibro("Cien años copia", "Otro autor", "978-0307474728", "Novela", 2020, 2);
        System.out.println("¿Permitió ISBN duplicado? " + resDuplicado);

        System.out.println("\n--- Libros de Gabriel García Márquez ---");
        for (Libro l : miBiblioteca.filtrarPorAutor("García Márquez")) {
            System.out.println(l.getTitulo() + " (" + l.getAño() + ")");
        }

        boolean eliminado = miBiblioteca.eliminarLibro("978-9588939775");
        System.out.println("\n¿Libro eliminado con éxito? " + eliminado);
        System.out.println("Total de libros restantes: " + miBiblioteca.obtenerTodos().size());

        // Lanzar interfaz gráfica
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal(miBiblioteca);
            ventana.setVisible(true);
        });
    }
}
