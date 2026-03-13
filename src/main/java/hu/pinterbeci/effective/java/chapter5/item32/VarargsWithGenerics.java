package hu.pinterbeci.effective.java.chapter5.item32;

import java.util.List;

public final class VarargsWithGenerics {

    private VarargsWithGenerics(){}

    /**
     * varargs - is an array under the hood; This is a parameterized types are non-reifiable, and mixed with a
     * reifiable in compile time, like this List<String>[] stringLists, a little bit weird;
     * A varargs parameters whose inferred type is non-reifiable;
     * Heap pollution - occurs when a variable of a parameterized type refers to an object that is not that type.
     *
     * @param stringLists
     */
    // important mixing generics and varargs not typesafe
    public static void dangerous(List<String>... stringLists) {
        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        //important this intList is a List<Integer> a parameterized type;
        // and here I assign that to a non parameterized reference, absolutely heap pollution
        objects[0] = intList; // Heap pollution
        String s = stringLists[0].get(0); // ClassCastException
        //important this is a List<String> non-reifiable type, and cannot cast to String
    }

    static <T> T[] toArray(T... args) {
        return args;
    }
}
