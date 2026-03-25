package materiales;
public class Libro extends Material {
    private String genero;
    private String editorial;
    public Libro(String codigo, String titulo, String autor, int anioPublicacion,
                 int numeroPaginas, String genero, String editorial) {
        super(codigo, titulo, autor, anioPublicacion, numeroPaginas);
        this.genero = genero;
        this.editorial = editorial;
    }
    public String getGenero() { return genero; }
    public String getEditorial() { return editorial; }
    public void setGenero(String genero) { this.genero = genero; }
    public void setEditorial(String editorial) { this.editorial = editorial; }
    @Override
    public String getTipoMaterial() { return "Libro"; }
    @Override
    public String toString() {
        return super.toString() + String.format("\n   Género: %s | Editorial: %s",
                genero, editorial);
    }
}