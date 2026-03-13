package hu.pinterbeci.effective.java.chapter5.item32;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class VarargsWithGenericsTest {

    private static ThreadLocalRandom random;

    @BeforeAll
    static void beforeAll() {
        random = ThreadLocalRandom.current();
    }

    @Test
    void should_fails_on_dangerous() {
        assertThatThrownBy(() -> {
            VarargsWithGenerics.dangerous(
                    List.of("a", "b"), List.of("22", "2222")
            );
        }).isInstanceOf(ClassCastException.class);
    }

    @Test
    void should_failsOnPick() {
        assertThatThrownBy(() -> {
            //in runtime pickTwo returns an Object[]
            //and I want this attributes refer to this Object[], like this
            //Object[] objects = new Object[]{};
            //String[] attributes = objects;

            String[] attributes = pickTwo("Good", "Fast", "Cheap");
        }).isInstanceOf(ClassCastException.class);
    }

    @Test
    void should_pickSafely() {
        assertDoesNotThrow(() -> {
            List<String> safePicks = pickTwoSafe("oooo", "erttt", "poo");
        });
    }

    // UNSAFE - Exposes a reference to its generic parameter array!
    private <T> T[] toArray(T... args) {
        //in compile time> args is an Object[] regarding the T type parameter
        return args;
    }

    private <T> T[] pickTwo(T a, T b, T c) {
        switch (random.nextInt(3)) {
            case 0:
                return toArray(a, b);
            case 1:
                return toArray(a, c);
            case 2:
                return toArray(b, c);
        }
        throw new AssertionError(); // Can't get here
    }

    private <T> List<T> pickTwoSafe(T a, T b, T c) {
        switch (random.nextInt(3)) {
            case 0:
                return List.of(a, b);
            case 1:
                return List.of(a, c);
            case 2:
                return List.of(b, c);
        }
        throw new AssertionError();
    }
}