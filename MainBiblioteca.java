package materiales;

import materiales.Audiolibro;
import materiales.Libro;
import materiales.Revista;
import prestamo.Prestamo;
import usuarios.Usuario;
import java.time.LocalDate;
public class MainBiblioteca {
    public static void main(String[] args) {

        Libro libro1 = new Libro(
                "L001", "Cien años de soledad", "Gabriel García Márquez",
                1967, 432, "Novela", "Sudamericana");
        Libro libro2 = new Libro(
                "L002", "El principito", "Antoine de Saint-Exupéry",
                1943, 96, "Fábula", "Gallimard");
        Revista revista1 = new Revista(
                "R001", "National Geographic", "Varios autores",
                2024, 120, 385, "Marzo");
        Audiolibro audio1 = new Audiolibro(
                "A001", "Sapiens", "Yuval Noah Harari",
                2011, 443, 870, "Carlos Lombardo", "MP3");
        Audiolibro audio2 = new Audiolibro(
                "A002", "Atomic Habits", "James Clear",
                2018, 320, 480, "Robert Petkoff", "WAV");

        Usuario usuario1 = new Usuario(
                "María López", "ID-1001", "555-8001", "Av. Reforma 100");
        Usuario usuario2 = new Usuario(
                "Carlos Mendoza", "ID-2002", "555-8002", "Calle 5 de Mayo 45");

        System.out.println("\n╔══════════════════════════════╗");
        System.out.println("  CASO 1: Préstamo de María    ");
        System.out.println("╚══════════════════════════════╝");
        Prestamo prestamo1 = new Prestamo(usuario1, LocalDate.of(2025, 6, 10));
        prestamo1.prestarMaterial(libro1);
        prestamo1.prestarMaterial(revista1);
        prestamo1.prestarMaterial(audio1);

        prestamo1.prestarMaterial(libro2);
        prestamo1.mostrarInformacion();

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("  CASO 2: Préstamo de Carlos     ");
        System.out.println("╚════════════════════════════════╝");
        Prestamo prestamo2 = new Prestamo(usuario2, LocalDate.of(2025, 6, 10));

        prestamo2.prestarMaterial(libro1);
        prestamo2.prestarMaterial(libro2);
        prestamo2.prestarMaterial(audio2);
        prestamo2.mostrarInformacion();

        System.out.println("\n╔════════════════════════════════╗");
        System.out.println("  CASO 3: Devolución de María    ");
        System.out.println("╚════════════════════════════════╝");
        prestamo1.devolverMateriales(LocalDate.of(2025, 6, 11));
        prestamo1.mostrarInformacion();

        System.out.println("\n>> Estado de libro1 tras devolución: " +
                libro1.getEstado());
        System.out.println(">> Estado de audio1 tras devolución: " +
                audio1.getEstado());
    }
}