import java.util.Scanner;

public class Manager {
    private ColeccionVinilos colection;

    public Manager() {
        colection = new ColeccionVinilos();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            showMenu();
            int option = getOption(scanner);

            switch (option) {
                case 1:
                    addVinilo(scanner);
                    break;
                case 2:
                    searchVinilo(scanner);
                    break;
                case 3:
                    showAmountVinilos();
                    break;
                case 4:
                    showAvailableSpaces();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }

    private int getOption(Scanner scanner) {
        return scanner.nextInt(); // Captura la opción
    }

    private void showMenu() {
        System.out.println("\n--- Manager Colección de Vinilos ---");
        System.out.println("1. Agregar vinilo");
        System.out.println("2. Buscar vinilo");
        System.out.println("3. Mostrar cantidad de vinilos");
        System.out.println("4. Mostrar espacios disponibles");
        System.out.println("5. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private void addVinilo(Scanner scanner) {
        System.out.print("Nombre del artista: ");
        String artista = scanner.next(); // Cambiado a next() para capturar solo la palabra
        System.out.print("Nombre del disco: ");
        String disco = scanner.next(); // Cambiado a next() para capturar solo la palabra
        System.out.print("Año de lanzamiento: ");
        int anoLanzamiento = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        Vinilo nuevoVinilo = new Vinilo(artista, disco, anoLanzamiento);
        colection.addVinilo(nuevoVinilo);
    }

    private void searchVinilo(Scanner scanner) {
        System.out.print("Nombre del artista: ");
        String artista = scanner.next();
        System.out.print("Nombre del disco: ");
        String disco = scanner.next();

        Vinilo viniloEncontrado = colection.searchVinilo(artista, disco);
        if (viniloEncontrado != null) {
            System.out.println("Vinilo encontrado: " + viniloEncontrado);
        } else {
            System.out.println("Vinilo no encontrado en la colección.");
        }
    }

    private void showAmountVinilos() {
        System.out.println("Cantidad de vinilos: " + colection.amountVinilo());
    }

    private void showAvailableSpaces() {
        System.out.println("Espacios disponibles: " + colection.availableSpace());
    }
}