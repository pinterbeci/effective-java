package hu.pinterbeci.effective.java.chapter5.item30;

import org.junit.jupiter.api.Test;

import java.util.function.UnaryOperator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class IdentityTest {

    @Test
    void should_identify_strings() {
        assertDoesNotThrow(() -> {
            String[] fruits = {"apple", "lemon"};
            UnaryOperator<String> sameFruits = Identity.identityFunction();
            for (String fruit : fruits)
                System.out.println(sameFruits.apply(fruit));
        });
    }

    @Test
    void should_identify_integers() {
        assertDoesNotThrow(() -> {
            Integer[] integers = {1, 222, 22222};
            UnaryOperator<Integer> sameInteger = Identity.identityFunction();

            for (Integer integer : integers)
                System.out.println(sameInteger.apply(integer));
        });
    }
}