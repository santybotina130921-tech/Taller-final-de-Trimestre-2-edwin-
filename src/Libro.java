public class Libro extends MaterialBibliografico {
    private String genero;
    private int copiasDisponibles;

    public Libro(String titulo, String autor, String isbn, String genero, int año, int copias) {
        super(titulo, autor, isbn, año);
        this.genero = genero;
        this.copiasDisponibles = copias;
    }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public int getCopiasDisponibles() { return copiasDisponibles; }
    public void setCopiasDisponibles(int copiasDisponibles) { this.copiasDisponibles = copiasDisponibles; }

    public String getIsbn() { return getCodigo(); }
    public void setIsbn(String isbn) { setCodigo(isbn); }

    @Override
    public String getTipo() {
        return "Libro";
    }

    @Override
    public String toString() {
        return "Libro [ Título=" + getTitulo() + ", Autor=" + getAutor() + ", ISBN=" + getCodigo() +
                ", Género=" + genero + ", Año=" + getAño() + ", Copias=" + copiasDisponibles + "]";
    }
}