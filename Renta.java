package renta;
import Cliente.Cliente;
import vehiculos.Camioneta;
import vehiculos.Motocicleta;
import vehiculos.Vehiculo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Renta {
    private LocalDate fechaRenta;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Cliente cliente;
    private Vehiculo vehiculo;
    public Renta(LocalDate fechaRenta, LocalDate fechaInicio, LocalDate fechaFin,
                 Cliente cliente, Vehiculo vehiculo) {
        this.fechaRenta = fechaRenta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }
    public long calcularDias() {
        return ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }
    public double calcularCostoTotal() {
        long dias = calcularDias();
        double costoPorDia = vehiculo.getCostoPorDia();
        double total = costoPorDia * dias;
        // Regla 1: más de 7 días → 10% descuento
        if (dias > 7) {
            total *= 0.90;
            System.out.println("   ✔ Descuento aplicado: 10% por renta mayor a 7 días.");
        }
        // Regla 2: motocicleta → 5% adicional de descuento por día
        if (vehiculo instanceof Motocicleta) {
            double descuentoMoto = costoPorDia * dias * 0.05;
            total -= descuentoMoto;
            System.out.println("   ✔ Descuento adicional: 5% por ser motocicleta.");
        }
        // Regla 3: camioneta 4x4 → 15% cargo adicional por seguro
        if (vehiculo instanceof Camioneta) {
            Camioneta camioneta = (Camioneta) vehiculo;
            if (camioneta.es4x4()) {
                double cargoSeguro = costoPorDia * dias * 0.15;
                total += cargoSeguro;
                System.out.println("   ✔ Cargo adicional: 15% por seguro obligatorio (Camioneta 4x4).");
            }
        }
        return total;
    }
    public LocalDate getFechaRenta() { return fechaRenta; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public Cliente getCliente() { return cliente; }
    public Vehiculo getVehiculo() { return vehiculo; }
    @Override
    public String toString() {
        long dias = calcularDias();
        return String.format(
                "=== RENTA ===\n" +
                        "Fecha de renta : %s\n" +
                        "Inicio         : %s\n" +
                        "Fin            : %s\n" +
                        "Días           : %d\n" +
                        "Cliente        : %s\n" +
                        "Vehículo       : %s\n" +
                        "Costo base     : $%.2f\n" +
                        "Desglose de cargos:",
                fechaRenta, fechaInicio, fechaFin, dias,
                cliente.getNombre(), vehiculo.toString(),
                vehiculo.getCostoPorDia() * dias
        );
    }
}