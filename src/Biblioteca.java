import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private HashMap<String, Libro> mapaIsbn;
    private HashSet<String> codigosIsbn;

    // Constructor
    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.mapaIsbn = new HashMap<>();
        this.codigosIsbn = new HashSet<>();
    }

    //agregar

    public boolean agregarLibro(String titulo, String autor, String isbn, String genero, int año, int copias) {
        if (titulo == null || titulo.trim().isEmpty() ||
                autor == null || autor.trim().isEmpty() ||
                isbn == null || isbn.trim().isEmpty() ||
                genero == null || genero.trim().isEmpty()) {
            return false;
        }
        //isbn y ya esiste ellibro
        // Usamos el HashSet para verificar  si ya existe el ISBN
        if (codigosIsbn.contains(isbn)) {
            return false;
        }
        if (año > 2026) {
            return false;
        }
        if (copias < 0) {
            return false;
        }
        Libro nuevoLibro = new Libro(titulo, autor, isbn, genero, año, copias);
        listaLibros.add(nuevoLibro);
        mapaIsbn.put(isbn, nuevoLibro);
        codigosIsbn.add(isbn);

        return true;
    }
    //obtener
    public ArrayList<Libro> obtenerTodos() {
        return listaLibros;
    }
    //buscar
    public ArrayList<Libro> filtrarPorAutor(String autorBuscado) {
        ArrayList<Libro> resultado = new ArrayList<>();
        if (autorBuscado == null || autorBuscado.trim().isEmpty()) {
            return resultado;
        }

        for (Libro libro : listaLibros) {
            if (libro.getAutor().toLowerCase().contains(autorBuscado.toLowerCase().trim())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    //eliminar

    public boolean eliminarLibro(String isbn) {
        Libro libroAEliminar = mapaIsbn.get(isbn);
        if (libroAEliminar != null) {
            listaLibros.remove(libroAEliminar);
            mapaIsbn.remove(isbn);
            codigosIsbn.remove(isbn);
            return true;
        }
        return false;
    }
}
