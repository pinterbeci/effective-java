package hu.pinterbeci.effective.java.chapter5.item28;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PreferListToArrayTest {

    /**
     * array is covariant - if Sub is subtype of Super, then Sub[] is subtype of the Super[]
     * list is invariant - two distinct Type1, Type2, List<Type1> neither subtype, and nor supertype of Lis<Type2>
     * </n>
     * array is reified - it knows and enforces their element type at runtime. REIFIABLE TYPES
     * generics (like a list) is erasure - it enforces their type constraints only at compile time and discard
     * (or erase) their element type information at runtime. NON-REIFIABLE TYPES
     */

    @Test
    void should_demonstrate_reified_in_runtime() {
        assertThatThrownBy(() -> {
            Object[] objectArray = new Long[1];
            objectArray[0] = "I don't fit in";
        }).isInstanceOf(ArrayStoreException.class);
    }

    @Test
    void should_demonstrate_type_erasure_in_runtime() {
        List<String> strings = new ArrayList<>();
        //it does not compile
        //strings.add('p');

        List<Integer> integers = new ArrayList<>();

        // Due to erasure, both are just List at runtime
        assertThat(strings.getClass()).isEqualTo(integers.getClass());
    }

}
