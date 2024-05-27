package src.uy.edu.um.adt.hashCerrado;


public interface hashInterfaze<K, V> {
    public void put(K key, V value);
    
    public boolean contains(K key);
    
    public void remove(K clave);
}

