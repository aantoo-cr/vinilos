public class Vinilo {
    private String artist;
    private String disk;
    private int year;

    // Constructor
    public Vinilo(String artista, String disco, int anoLanzamiento) {
        this.artist = artista;
        this.disk = disco;
        this.year = anoLanzamiento;
    }

    // Metodo toString para representar el objeto como String
    @Override
    public String toString() {
        return "Artista: " + artist + ", Disco: " + disk + ", Año de Lanzamiento: " + year;
    }

    public String getDisk() {
        return disk;
    }

    public String getArtist() {
        return artist;
    }
}

