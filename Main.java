import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre de la playlist: ");
        String nombrePlaylist = scanner.nextLine();
        Playlist playlist = new Playlist(nombrePlaylist);

        int opcion = 0;

        do {
            System.out.println("\n=================================");
            System.out.println("      MENÚ DE LA PLAYLIST        ");
            System.out.println("=================================");
            System.out.println("1. Agregar canción");
            System.out.println("2. Mostrar canciones");
            System.out.println("3. Eliminar canción");
            System.out.println("4. Mostrar cantidad de canciones");
            System.out.println("5. Buscar canción");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Entrada inválida. Ingrese un número del 1 al 6.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Título de la canción: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Artista: ");
                    String artista = scanner.nextLine();
                    System.out.print("Duración (en segundos): ");

                    int duracion = 0;
                    if (scanner.hasNextInt()) {
                        duracion = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Duración no válida. Se registrará 0 segundos por defecto.");
                        scanner.nextLine();
                    }

                    Cancion nuevaCancion = new Cancion(titulo, artista, duracion);
                    playlist.agregarCancion(nuevaCancion);
                    break;

                case 2:
                    playlist.mostrarCanciones();
                    break;

                case 3:
                    if (playlist.getCantidadCanciones() == 0) {
                        System.out.println("No hay canciones disponibles para eliminar.");
                    } else {
                        playlist.mostrarCanciones();
                        System.out.print("Seleccione el número de la canción a eliminar: ");
                        if (scanner.hasNextInt()) {
                            int numEliminar = scanner.nextInt();
                            scanner.nextLine();
                            playlist.eliminarCancion(numEliminar - 1);
                        } else {
                            System.out.println("Número no válido.");
                            scanner.nextLine();
                        }
                    }
                    break;

                case 4:
                    playlist.mostrarCantidad();
                    break;

                case 5:
                    System.out.print("Ingrese el título de la canción a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    playlist.buscarCancion(tituloBuscar);
                    break;

                case 6:
                    System.out.println("\n--- Resumen Final ---");
                    System.out.println("Nombre de la playlist: " + playlist.getNombre());
                    System.out.println("Cantidad de canciones almacenadas: " + playlist.getCantidadCanciones());
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente de nuevo.");
            }
        } while (opcion != 6);

        scanner.close();
    }
}
