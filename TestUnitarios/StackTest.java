package TestUnitarios;

import uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import uy.edu.um.adt.stack.EmptyStackException;
import uy.edu.um.adt.stack.MyStack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {
    public static void main(String[] args) {

        MyStack<String> testStack = new MyLinkedListImpl<>();

        try{
            testStack.push("1");
            testStack.push("2");
            testStack.push("3");
            testStack.pop();
            assertEquals("2",testStack.peek());
            testStack.pop();
            assertEquals("1",testStack.peek());
            testStack.pop();
        } catch (EmptyStackException _){}

        testStack.push("1");
        assertEquals("1",testStack.peek());
        testStack.push("2");
        assertEquals("2",testStack.peek());
        testStack.push("3");
        assertEquals("3",testStack.peek());
        assertEquals(3,testStack.size());

        testStack.push("4");
        assertEquals("4",testStack.peek());
        testStack.push("5");
        assertEquals("5",testStack.peek());
        assertEquals(5,testStack.size());

        try {
            testStack.pop();
            testStack.pop();
            testStack.pop();
            testStack.pop();
            assertEquals(1, testStack.size());
            testStack.pop();
            assertEquals(0, testStack.size());

        } catch (EmptyStackException _){}






    }

}
