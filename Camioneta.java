package vehiculos;
public class Camioneta extends Vehiculo {
    private String tipoTraccion; // "4x2" o "4x4"
    private double capacidadCargaKg;
    private int numeroFilasAsientos;
    public Camioneta(String numeroDePlaca, String marca, String modelo, int anio,
                     double costoPorDia, String tipoTraccion, double capacidadCargaKg,
                     int numeroFilasAsientos) {
        super(numeroDePlaca, marca, modelo, anio, costoPorDia);
        this.tipoTraccion = tipoTraccion;
        this.capacidadCargaKg = capacidadCargaKg;
        this.numeroFilasAsientos = numeroFilasAsientos;
    }
    public String getTipoTraccion() { return tipoTraccion; }
    public double getCapacidadCargaKg() { return capacidadCargaKg; }
    public int getNumeroFilasAsientos() { return numeroFilasAsientos; }
    public void setTipoTraccion(String tipoTraccion) { this.tipoTraccion = tipoTraccion;
    }
    public void setCapacidadCargaKg(double capacidadCargaKg) { this.capacidadCargaKg =
            capacidadCargaKg; }
    public void setNumeroFilasAsientos(int numeroFilasAsientos) {
        this.numeroFilasAsientos = numeroFilasAsientos; }
    public boolean es4x4() {
        return "4x4".equalsIgnoreCase(tipoTraccion);
    }
    @Override
    public String getTipoVehiculo() { return "Camioneta"; }
    @Override
    public String toString() {
        return super.toString() + String.format("\n   Tracción: %s | Carga máx: %.1f kg | Filas de asientos: %d",
        tipoTraccion, capacidadCargaKg, numeroFilasAsientos);
    }
}