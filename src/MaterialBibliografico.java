public abstract class MaterialBibliografico {
    protected String titulo;
    protected String autor;
    protected String codigo;
    protected int año;

    public MaterialBibliografico(String titulo, String autor, String codigo, int año) {
        this.titulo = titulo;
        this.autor = autor;
        this.codigo = codigo;
        this.año = año;
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public int getAño() { return año; }
    public void setAño(int año) { this.año = año; }

    public abstract String getTipo();
}