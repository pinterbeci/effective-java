package hu.pinterbeci.effective.java.chapter5.item31;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stack<E> {
    private final List<E> elements;

    public Stack() {
        this.elements = new ArrayList<>(16);
    }

    public void push(E e) {
        elements.add(e);
    }

    public E pop() {
        E result = elements.get(elements.size() - 1);
        elements.remove(result);

        return result;
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    /*
        //non-flexible pushAll, this is bounded for parameter type 'E'
        public void pushAll(Iterable<E> src) {
            for (E e : src)
                push(e);
        }
    */

    //PECS - Producer Extends Consumer Super
    //read from Producer (GET)
    //write to Consumer (PUT)
    public void pushAll(Iterable<? extends E> src) {
        for (E e : src)
            push(e);
    }

    public void popAll(Collection<? super E> dst) {
        while (!isEmpty()) dst.add(pop());
    }

    //IMPORTANT!!!!!!!!!!!!!!!!!!!!!!! DO NOT USE BOUNDED WILDCARD TYPES AS A RETURN TYPE
    // if a type parameter appears only once in a method declaration, replace it with a wildcard.

}

