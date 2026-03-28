package hu.pinterbeci.effective.java.chapter6.item38;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class OperationTest {

    @Test
    void successfully_run_the_test(){
        assertDoesNotThrow(() -> test(BasicOperation.class, 2.1, 3.456));
    }

    private <T extends Enum<T> & Operation> void test(
            Class<T> opEnumType, double x, double y) {
        for (Operation op : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
}
