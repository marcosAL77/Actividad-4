package vehiculos;
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    private String tipo; // "urbana", "deportiva", "trabajo"
    private boolean incluyeCasco;
    public Motocicleta(String numeroDePlaca, String marca, String modelo, int anio,
                       double costoPorDia, int cilindrada, String tipo, boolean
                               incluyeCasco) {
        super(numeroDePlaca, marca, modelo, anio, costoPorDia);
        this.cilindrada = cilindrada;
        this.tipo = tipo;
        this.incluyeCasco = incluyeCasco;
    }
    public int getCilindrada() { return cilindrada; }
    public String getTipo() { return tipo; }
    public boolean isIncluyeCasco() { return incluyeCasco; }
    public void setCilindrada(int cilindrada) { this.cilindrada = cilindrada; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setIncluyeCasco(boolean incluyeCasco) { this.incluyeCasco =
            incluyeCasco; }
    @Override
    public String getTipoVehiculo() { return "Motocicleta"; }
    @Override
    public String toString() {
        return super.toString() + String.format("\n   Cilindrada: %dcc | Tipo: %s |
                Casco: %s",
        cilindrada, tipo, incluyeCasco ? "Sí" : "No");
    }
}