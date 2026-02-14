package hu.pinterbeci.effective.java.chapter3.item13;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Stack implements Cloneable {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        this.elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object result = elements[--size];
        elements[size] = null; // Eliminate obsolete reference
        return result;
    }

    // Clone method for class with references to mutable state;
    //mutable state means this context - this class has one static field;
    //after the clone this static field copies as well, and does not initiate new one


    // the Cloneable architecture is incompatible with normal use of final fields referring to mutable objects;
    @Override
    public Stack clone() {
        try {
            Stack result = (Stack) super.clone();
            //it is important to clone the MUTABLE, COLLECTION, ARRAY OR MAP typed field as well
            //creat deep copy, look the Table
            result.elements = elements.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Stack stack)) return false;
        return size == stack.size && Arrays.equals(elements, stack.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    // Ensure space for at least one more element.
    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }
}
