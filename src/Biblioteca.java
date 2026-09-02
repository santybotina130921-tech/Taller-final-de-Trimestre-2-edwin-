import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
    private ArrayList<Libro> listaLibros;
    private HashMap<String, Libro> mapaIsbn;

    // Constructor
    public Biblioteca() {
        this.listaLibros = new ArrayList<>();
        this.mapaIsbn = new HashMap<>();
    }
}
