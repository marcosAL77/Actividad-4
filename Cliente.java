package Cliente;
public class Cliente {
    private String nombre;
    private String celular;
    private String identificacion; // INE u otra identificación válida
    public Cliente(String nombre, String celular, String identificacion) {
        this.nombre = nombre;
        this.celular = celular;
        this.identificacion = identificacion;
    }
    public String getNombre() { return nombre; }
    public String getCelular() { return celular; }
    public String getIdentificacion() { return identificacion; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setIdentificacion(String identificacion) { this.identificacion =
            identificacion; }
    @Override
    public String toString() {
        return String.format("Cliente: %s | Cel: %s | ID: %s", nombre, celular,
                identificacion);
    }
}