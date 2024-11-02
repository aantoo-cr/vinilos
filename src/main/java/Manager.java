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
            int option = getOption(scanner); // Cambié el flujo aquí

            switch (option) {
                case 1:
                    addVinilo(scanner);
                    break;
                case 2:
                    searchVinilo(scanner);
                    break;
                case 3:
                    showAmountvinilos();
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
        // Agregar manejo de excepción para asegurarse de que el valor ingresado sea un entero
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine()); // Leer toda la línea
            } catch (NumberFormatException e) {
                System.out.print("Por favor, ingrese un número válido: ");
            }
        }
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
        String artista = scanner.nextLine(); // Captura el nombre completo del artista
        System.out.print("Nombre del disco: ");
        String disco = scanner.nextLine(); // Captura el nombre completo del disco
        System.out.print("Año de lanzamiento: ");

        // Ahora usamos el método getOption para leer el año
        int anoLanzamiento = getOption(scanner); // Aseguramos que se capture como entero

        Vinilo nuevoVinilo = new Vinilo(artista, disco, anoLanzamiento);
        colection.addVinilo(nuevoVinilo);
    }

    private void searchVinilo(Scanner scanner) {
        System.out.print("Nombre del artista: ");
        String artista = scanner.nextLine();
        System.out.print("Nombre del disco: ");
        String disco = scanner.nextLine();

        Vinilo viniloEncontrado = colection.searchVinilo(artista, disco);
        if (viniloEncontrado != null) {
            System.out.println("Vinilo encontrado: " + viniloEncontrado);
        } else {
            System.out.println("Vinilo no encontrado en la colección.");
        }
    }

    private void showAmountvinilos() {
        System.out.println("Cantidad de vinilos: " + colection.amountVinilo());
    }

    private void showAvailableSpaces() {
        System.out.println("Espacios disponibles: " + colection.availableSpace());
    }
}
