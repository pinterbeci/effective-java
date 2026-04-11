package hu.pinterbeci.effective.java.chapter7.item45;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class StreamCodeBlockVsLambdaTest {

    @Test
    public void should_read_and_modify_local_variable_in_stream_code_blocks() {
        final AtomicInteger sum = new AtomicInteger();

        Stream.of(1, 11, 111)
                .forEach(decimal -> {
                            System.out.println("sum changing from = " + sum);
                            sum.addAndGet(decimal);
                            System.out.println("sum changed to = " + sum);
                        }
                );
    }

    @Test
    public void should_read_local_variable_in_stream_lambdas() {
        final int age = 12;
        Runnable r = () -> {
            System.out.println(age);
        };
    }

    @Test
    public void should_return_and_break_in_stream_code_blocks() {
        boolean actual = contains(List.of(11, 222, 333), 9);
        assertThat(actual).isFalse();
    }

    private boolean contains(final List<Integer> decimals, final int i) {
        for (Integer decimal : decimals) {
            if (decimal == i) return true;
        }

        return false;
    }
}
