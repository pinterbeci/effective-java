package hu.pinterbeci.effective.java.chapter3.item13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class OverrideCloneTest {

    //understandable representation of clone
    @Test
    void should_clone_facility() {
        assertDoesNotThrow(() -> {
            Facility actual = new Facility("commercial");
            Facility expected = actual.clone();

            //contract of 'clone'
            assertThat(actual).isNotSameAs(expected);
            assertThat(actual.getClass()).isSameAs(expected.getClass());
            assertThat(actual).isEqualTo(expected);
        });
    }


    @Test
    void should_clone_stack() {
        assertDoesNotThrow(() -> {
            Stack actual = new Stack();
            Stack expected = actual.clone();

            assertThat(actual).isNotSameAs(expected);
            assertThat(actual.getClass()).isSameAs(expected.getClass());
            assertThat(actual).isEqualTo(expected);

            actual.push(Integer.valueOf("5"));
            assertThat(actual).isNotEqualTo(expected);
        });
    }

    @Test
    void should_copy_hash_table_without_recursive_deep_copy_of_the_bucket() {
        assertDoesNotThrow(() -> {
            HashTable actual = new HashTable();
            HashTable expected = actual.clone();

            assertThat(actual).isNotSameAs(expected);
            assertThat(actual.getClass()).isSameAs(expected.getClass());
            //according to the 'deepCopy' concepts, these two do not equal;
            //'deepCopy' relies on new references of the class field
            assertThat(actual).isNotEqualTo(expected);
        });
    }


}