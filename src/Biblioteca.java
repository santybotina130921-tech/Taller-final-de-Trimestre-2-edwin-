import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private HashMap<String, Libro> mapaIsbn;

    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.mapaIsbn = new HashMap<>();
    }

    public boolean agregarLibro(String titulo, String autor, String isbn, String genero, int año, int copias) {
        if (titulo == null || titulo.trim().isEmpty() ||
                autor == null || autor.trim().isEmpty() ||
                isbn == null || isbn.trim().isEmpty() ||
                genero == null || genero.trim().isEmpty()) {
            return false;
        }

        if (mapaIsbn.containsKey(isbn)) {
            return false; // ISBN duplicado
        }

        int añoActual = java.time.Year.now().getValue();
        if (año > añoActual || copias <= 0) {
            return false;
        }

        Libro nuevoLibro = new Libro(titulo, autor, isbn, genero, año, copias);
        listaLibros.add(nuevoLibro);
        mapaIsbn.put(isbn, nuevoLibro);
        return true;
    }

    public ArrayList<Libro> obtenerTodos() {
        return new ArrayList<>(listaLibros); // copia segura
    }

    public ArrayList<Libro> filtrarPorAutor(String autorBuscado) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getAutor().toLowerCase().contains(autorBuscado.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public boolean eliminarLibro(String isbn) {
        Libro libro = mapaIsbn.get(isbn);
        if (libro != null) {
            listaLibros.remove(libro);
            mapaIsbn.remove(isbn);
            return true;
        }
        return false;
    }
}
