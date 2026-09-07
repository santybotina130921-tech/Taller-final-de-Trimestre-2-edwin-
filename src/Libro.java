public class Libro {
    private String titulo, autor, isbn, genero;
    private int año, copiasDisponibles;

    public Libro(String titulo, String autor, String isbn, String genero, int año, int copiasDisponibles){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.año = año;
        this.copiasDisponibles = copiasDisponibles;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; } // corregido

    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }

    public int getCopiasDisponibles() { return copiasDisponibles; }
    public void setCopiasDisponibles(int copiasDisponibles) { this.copiasDisponibles = copiasDisponibles; }

    @Override
    public String toString() {
        return "Libro [Título=" + titulo + ", Autor=" + autor + ", ISBN=" + isbn +
                ", Género=" + genero + ", Año=" + año + ", Copias=" + copiasDisponibles + "]";
    }
}
