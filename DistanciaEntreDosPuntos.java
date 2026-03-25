import java.util.Scanner;
public class DistanciaEntreDosPuntos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x1,y1,x2,y2,distancia;

        System.out.println("Ingrese la cordenada x del primer punto: ");
        x1 = sc.nextDouble();
        System.out.println("Ingrese la cordenada y del primer punto: ");
        y1 = sc.nextDouble();
        System.out.println("Ingrese la cordenada x del segundo punto: ");
        x2 = sc.nextDouble();
        System.out.println("Ingrese la cordenada y del segundo punto: ");
        y2 = sc.nextDouble();

        distancia = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

        System.out.println("La distancia entre los dos puntos es: " + distancia);
        sc.close();
    }
}
