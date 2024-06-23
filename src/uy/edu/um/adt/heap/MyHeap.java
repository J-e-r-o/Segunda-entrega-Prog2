package src.uy.edu.um.adt.Heap;

public interface MyHeap<T extends Comparable<T>> {
    void insert(T value) throws HeapOverflow;
    T delete() throws EmptyHeapException;
    int size();
    boolean isEmpty();
    String toString();
    T top();

}
