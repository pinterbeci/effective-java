package hu.pinterbeci.effective.java.chapter2.item6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {
    @Test
    void should_compare_execution_times() {
        long startOfSum = System.currentTimeMillis();
        Operation.sum();
        long endOfSum = System.currentTimeMillis();
        long executionTimeOfSum = endOfSum - startOfSum;
        System.out.println("Execution time of the 'sum':" + executionTimeOfSum);

        long startOfSum2 = System.currentTimeMillis();
        Operation.sum2();
        long endOfSum2 = System.currentTimeMillis();
        long executionTimeOfSum2 = endOfSum2 - startOfSum2;
        System.out.println("Execution time of the 'sum2':" + executionTimeOfSum2);

        assertThat(executionTimeOfSum2).isLessThan(executionTimeOfSum);
    }
}