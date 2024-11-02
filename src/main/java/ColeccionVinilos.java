import java.util.ArrayList;
import java.util.List;

public class ColeccionVinilos {
    private List<Vinilo> vinilos;
    private int maxVinilos;

    // Constructor
    public ColeccionVinilos() {
        this.vinilos = new ArrayList<>();
        this.maxVinilos = 100;
    }

    // Metodo para agregar un vinilo a la colección
    public void addVinilo(Vinilo vinilo) {
        if (vinilos.size() < maxVinilos) {
            vinilos.add(vinilo);
            System.out.println("Vinilo agregado: " + vinilo);
        } else {
            System.out.println("La colección está llena. No se puede agregar más vinilos.");
        }
    }

    // Metodo para buscar un vinilo por artista y disco
    public Vinilo searchVinilo(String artista, String disco) {
        for (Vinilo vinilo : vinilos) {
            if (vinilo.getArtist().equals(artista) && vinilo.getDisk().equals(disco)) {
                return vinilo;
            }
        }
        return null;
    }

    // Metodo para obtener la cantidad de vinilos en la colección
    public int amountVinilo() {
        return vinilos.size();
    }

    // Metodo para obtener el número de espacios disponibles en la colección
    public int availableSpace() {
        return maxVinilos - vinilos.size();
    }
}

