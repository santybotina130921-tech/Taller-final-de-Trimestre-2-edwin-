public class Libro {
    // atributos
    private String titulo, autor, isbn, genero;
    private int año, copiasDisponibles;

    //constructor
    public Libro(String titulo, String autor, String isbn, String genero, int año, int copias){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.genero = genero;
        this.año = año;
        this.copiasDisponibles = copias;
    }
    // funciones / getters y setters

    //titulo

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    //autor

    public String getAutor() {return  autor;}
    public void setAutor(String autor) { this.autor = autor; }

    //isbn

    public String getIsbn() {return  isbn;}
    public void setIsbn(String isbn) { this.isbn = isbn; }

    //genero

    public String getGenero() {return  genero;}
    public void setGenero(String genero) { this.genero = genero; }

    //año

    public int getAño() {return  año;}
    public void setAño(int año) { this.año = año; }

    //copias Disponibles

    public int getCopiasDisponibles() {return  copiasDisponibles;}
    public void setCopiasDisponibles(int copiasDisponibles) { this.copiasDisponibles = copiasDisponibles; }


    // método toString()

    @Override
    public String toString() {
        return "Libro [ Título=" + titulo + ", Autor=" + autor + ", ISBN=" + isbn +
                ", Género=" + genero + ", Año=" + año + ", Copias=" + copiasDisponibles + "]";
    }}
