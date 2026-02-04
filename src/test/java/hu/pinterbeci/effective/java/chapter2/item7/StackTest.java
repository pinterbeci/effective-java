package hu.pinterbeci.effective.java.chapter2.item7;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class StackTest {
    @Test
    void should_reject_pop_on_empty_stack() {
        assertThatThrownBy(() -> {
                    Stack stack = new Stack();
                    stack.pop();
                }
        );
    }

    @Test
    void should_add_new_element_to_stack() {
        int expected = 5;
        Stack stack = new Stack();
        stack.push(expected);

        Object actual = stack.getElements()[0];
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void should_add_multiple_elements_to_stack() {
        int first = 4;
        int second = 5;
        Stack stack = new Stack();

        stack.push(first);
        stack.push(second);

        Object[] actual = stack.getElements();

        assertThat(actual.length).isEqualTo(16);
        assertThat(actual[0]).isEqualTo(first);
        assertThat(actual[1]).isEqualTo(second);
        assertThat(actual[2]).isNull();
    }

    @Test
    void should_increase_stack_capacity() {
        Stack stack = new Stack();
        for (int i = 0; i < 17; i++) {
            stack.push(i);
        }
        assertThat(stack.getElements().length).isEqualTo(33);
    }

    @Test
    void should_pop_multiple_items() {
        Stack stack = new Stack();
        for (int i = 0; i < 17; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 17; i++) {
            stack.pop();
        }

        assertThat(stack.getElements()[2]).isNull();
        assertThat(stack.getElements()[10]).isNull();
        assertThat(stack.getElements()[1]).isNull();
        assertThat(stack.getElements()[9]).isNull();
    }
}