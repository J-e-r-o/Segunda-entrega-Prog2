package Main;

public class NodoCancion2 implements Comparable<NodoCancion2> {

    String id;
    String artista;
    String nombre;
    int apariciones;


    public NodoCancion2(String id, String artista, String nombre) {
        this.id = id;
        this.artista = artista;
        this.nombre = nombre;
        this.apariciones = 1;
    }


    @Override
    public String toString () {
        return "Cancion{" +
                "id='" + id + '\'' +
                ", artista='" + artista + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apariciones=" + apariciones +
                '}';
    }

    @Override
    public int compareTo (NodoCancion2 other){
        return Integer.compare(this.apariciones, other.apariciones);
    }


}
