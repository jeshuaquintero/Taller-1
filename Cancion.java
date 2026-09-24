public class Cancion {
    private String titulo;
    private String artista;
    private int duracionSegundos;

    public Cancion(String titulo, String artista, int duracionSegundos) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracionSegundos = duracionSegundos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + titulo + " | Artista: " + artista + " | Duración: " + duracionSegundos + " s");
    }
}
