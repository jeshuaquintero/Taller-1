import java.util.ArrayList;

public class Playlist {
    private String nombre;
    private ArrayList<Cancion> canciones;

    public Playlist(String nombre) {
        this.nombre = nombre;
        this.canciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarCancion(Cancion cancion) {
        canciones.add(cancion);
        System.out.println("-> Canción '" + cancion.getTitulo() + "' agregada con éxito.");
    }

    public void mostrarCanciones() {
        if (canciones.isEmpty()) {
            System.out.println("La playlist está vacía.");
            return;
        }
        System.out.println("\n--- Lista de Canciones ---");
        for (int i = 0; i < canciones.size(); i++) {
            System.out.print((i + 1) + ". ");
            canciones.get(i).mostrarInformacion();
        }
    }

    public void eliminarCancion(int indice) {
        if (indice >= 0 && indice < canciones.size()) {
            Cancion eliminada = canciones.remove(indice);
            System.out.println("-> Se eliminó la canción: " + eliminada.getTitulo());
        } else {
            System.out.println("Error: El número ingresado no corresponde a ninguna canción.");
        }
    }

    public void mostrarCantidad() {
        System.out.println("Total de canciones almacenadas: " + canciones.size());
    }

    public void buscarCancion(String titulo) {
        boolean encontrada = false;
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("-> La canción se encuentra en la playlist:");
                cancion.mostrarInformacion();
                encontrada = true;
                break;
            }
        }
        if (!encontrada) {
            System.out.println("-> La canción '" + titulo + "' NO se encuentra en la playlist.");
        }
    }

    public int getCantidadCanciones() {
        return canciones.size();
    }
}