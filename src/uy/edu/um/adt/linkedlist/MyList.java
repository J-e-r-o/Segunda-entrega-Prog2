package src.uy.edu.um.adt.linkedlist;

import java.util.Iterator;

public interface MyList<T> {

    void add(T value);

    T get(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

    public Iterator<T> iterator();

}
