package materiales;
public abstract class Material {
    private String codigo;
    private String titulo;
    private String autor;
    private int anioPublicacion;
    private int numeroPaginas;
    private boolean disponible; // true = Disponible, false = Prestado
    public Material(String codigo, String titulo, String autor,
                    int anioPublicacion, int numeroPaginas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.numeroPaginas = numeroPaginas;
        this.disponible = true;
    }
    // Getters
    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAnioPublicacion() { return anioPublicacion; }
    public int getNumeroPaginas() { return numeroPaginas; }
    public boolean isDisponible() { return disponible; }
    public String getEstado() { return disponible ? "Disponible" : "Prestado"; }
    // Setters
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAnioPublicacion(int anioPublicacion) { this.anioPublicacion =
            anioPublicacion; }
    public void setNumeroPaginas(int numeroPaginas) { this.numeroPaginas =
            numeroPaginas; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
    public abstract String getTipoMaterial();
    @Override
    public String toString() {
        return String.format("[%s] Cód: %s | \"%s\" - %s (%d) | %d págs. | Estado: %s",
                getTipoMaterial(), codigo, titulo, autor, anioPublicacion,
                numeroPaginas, getEstado());
    }
}
