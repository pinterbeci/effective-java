package hu.pinterbeci.effective.java.chapter5.item26;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RawTypeTest {

    /**
     * If you use raw types, you lose all the safety and expressiveness benefits of generics.
     * The language designers permit the raw types for compatibility.
     * There is an enormous amount of code in existence that did not use generics (legacy systems etc.)
     * Raw types allow this old system to interoperate with newer code while maintaining its legality.
     * This requirement is the MIGRATION COMPATIBILITY, drove decision to support the type erasure.
     * With raw type you lose the type safety and boundaries of a generic type.
     */
    @Test
    void should_not_do_this() {

        //there is a warning for the raw type
        Collection items = new ArrayList<>();

        items.add(Integer.TYPE);
        items.add(Integer.valueOf(8));
        items.add(Byte.valueOf("4"));

        assertThatThrownBy(
                () -> items.forEach(item -> {
                    //there is an Integer cast; Idea removes by default the redundant casts
                    System.out.println((int) item);
                })
        );
    }

    @Test
    void should_not_use_unsafeAdd() {
        assertThatThrownBy(() -> {
            List<String> strings = new ArrayList<>();
            unsafeAdd(strings, Integer.valueOf("66"));
            toLowerCase(strings.get(0));
        });
    }

    @Test
    void should_use_unbounded_wildcard_instead_of_raw_type() {
        Set<Integer> integers = Set.of(9, 1_000);
        Set<Integer> primeNumbers = Set.of(1, 3, 5, 7);
        assertDoesNotThrow(() ->
                numElementsInCommon(integers, primeNumbers)
        );
    }

    private void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    /**
     * Wildcard and Generic Usage Guide
     *
     * | Situation                        | Use              |
     * |----------------------------------|------------------|
     * | Read + write, same type          | {@code <T>}      |
     * | Read only, any type              | {@code <? extends T>} |
     * | Write only                       | {@code <? super T>}   |
     * | Don't read OR write the elements | {@code <?>}      |
     */
    private <T> void afeAdd(List<T> list, T o) {
        list.add(o);
    }

    private int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1)
            if (s2.contains(o1))
                result++;
        return result;
    }

    private String toLowerCase(String str) {
        return str.toLowerCase();
    }
}
