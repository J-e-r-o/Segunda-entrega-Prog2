package src.uy.edu.um.adt.circularlinkedlist;

public interface MyCircularLinkedList<T> {
    void add(T value);

    T getCircularLogic(int position);

    boolean contains(T value);

    void remove(T value);

    int size();

s

}
