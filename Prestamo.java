package prestamo;
import materiales.Material;
import usuarios.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Prestamo {
    private static final int MAX_MATERIALES = 3;
    private Usuario usuario;
    private LocalDate fechaSolicitud;
    private LocalDate fechaDevolucion; // null si aún no devuelto
    private List<Material> materiales;
    public Prestamo(Usuario usuario, LocalDate fechaSolicitud) {
        this.usuario = usuario;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaDevolucion = null;
        this.materiales = new ArrayList<>();
    }

    public boolean prestarMaterial(Material material) {
        if (materiales.size() >= MAX_MATERIALES) {
            System.out.println("✘ No se pueden agregar más materiales. Límite de "
                    + MAX_MATERIALES + " alcanzado.");
            return false;
        }
        if (!material.isDisponible()) {
            System.out.println("✘ El material \"" + material.getTitulo() + "\" no está disponible.");
            return false;
        }
        material.setDisponible(false);
        materiales.add(material);
        System.out.println("✔ Material prestado: \"" + material.getTitulo() + "\"");
        return true;
    }

    public void devolverMateriales(LocalDate fechaDevolucion) {
        if (materiales.isEmpty()) {
            System.out.println("✘ Este préstamo no tiene materiales registrados.");
            return;
        }
        this.fechaDevolucion = fechaDevolucion;
        for (Material m : materiales) {
            m.setDisponible(true);
            System.out.println("✔ Devuelto: \"" + m.getTitulo() + "\" → Estado: Disponible");
        }
    }

    public boolean devolverMaterial(Material material, LocalDate fechaDevolucion) {
        if (!materiales.contains(material)) {
            System.out.println("✘ El material no pertenece a este préstamo.");
            return false;
        }
        material.setDisponible(true);
        System.out.println("✔ Devuelto: \"" + material.getTitulo() + "\" → Estado: Disponible");
                // Marcar devolución total si todos están disponibles
        boolean todosDevueltos = materiales.stream().allMatch(Material::isDisponible);
        if (todosDevueltos) {
            this.fechaDevolucion = fechaDevolucion;
        }
        return true;
    }

    public void mostrarInformacion() {

        System.out.println("╔══════════════════════════════════════════════════╗");
        System.out.println("              INFORMACIÓN DEL PRÉSTAMO              ");

        System.out.println("╚══════════════════════════════════════════════════╝");
        System.out.println("Usuario         : " + usuario.getNombre());
        System.out.println("Identificación  : " + usuario.getIdentificacion());
        System.out.println("Celular         : " + usuario.getCelular());
        System.out.println("Dirección       : " + usuario.getDireccion());
        System.out.println("Fecha solicitud : " + fechaSolicitud);
        System.out.println("Fecha devoluc.  : " + (fechaDevolucion != null ?
                fechaDevolucion : "Pendiente"));
        System.out.println("Materiales prestados (" + materiales.size() + "/" +
                MAX_MATERIALES + "):");
        if (materiales.isEmpty()) {
            System.out.println("   (ninguno)");
        } else {
            for (int i = 0; i < materiales.size(); i++) {
                System.out.println("   " + (i + 1) + ". " + materiales.get(i));
            }
        }
        System.out.println("──────────────────────────────────────────────────");
    }

    public Usuario getUsuario() { return usuario; }
    public LocalDate getFechaSolicitud() { return fechaSolicitud; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }
    public List<Material> getMateriales() { return materiales; }
}