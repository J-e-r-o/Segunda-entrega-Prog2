package src.uy.edu.um.adt.hashCerrado;


import src.uy.edu.um.adt.linkedlist.MyList;

public interface hashInterfaze<K, V> {
    public void put(K key, V value);
    
    public boolean contains(K key);
    
    public void remove(K clave);

    public V get(K key);

    public int size();

    public MyList<K> getKeys();
}

