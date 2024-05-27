package TestUnitarios;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.queue.EmptyQueueException;
import uy.edu.um.adt.queue.MyQueue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    public static void main(String[] args) {

        MyQueue<String> testQueue = new MyLinkedListImpl<>();

        try{
            testQueue.enqueue("1");
            testQueue.enqueue("2");
            testQueue.enqueue("3");
            testQueue.dequeue();
            assertTrue(testQueue.contains("2"));
            testQueue.dequeue();
            assertTrue(testQueue.contains("3"));
            testQueue.dequeue();
        } catch (EmptyQueueException _){}

        testQueue.enqueue("1");
        assertTrue(testQueue.contains("1"));
        testQueue.enqueue("2");
        assertTrue(testQueue.contains("2"));
        testQueue.enqueue("3");
        assertTrue(testQueue.contains("3"));
        assertEquals(3,testQueue.size());
        assertFalse(testQueue.contains("4"));
        assertFalse(testQueue.contains("5"));


        testQueue.enqueue("4");
        assertTrue(testQueue.contains("4"));
        testQueue.enqueue("5");
        assertTrue(testQueue.contains("4"));
        assertEquals(5,testQueue.size());

        try {
            testQueue.dequeue();
            testQueue.dequeue();
            testQueue.dequeue();
            testQueue.dequeue();
            assertEquals(1, testQueue.size());
            testQueue.dequeue();
            assertEquals(0, testQueue.size());
        } catch (EmptyQueueException _){}






    }

}
