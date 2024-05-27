package src.uy.edu.um.adt.hashCerrado;

public class HashNode<K,V> {
    K key;
    V valor;
    boolean borrado;

    public HashNode(K key, V valor){
        this.key= key;
        this.valor=valor;
        this.borrado=false;
    }

}
