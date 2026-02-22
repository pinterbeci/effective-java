package hu.pinterbeci.effective.java.chapter4.item18;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class InstrumentedHashSetTest {

    @Test
    void should_add_multiple_elements() {
        InstrumentedHashSet<String> s = new InstrumentedHashSet<>(new HashSet<>());
        s.addAll(List.of("Snap", "Crackle", "Pop"));

        assertThat(s).isNotEmpty();
        assertThat(s.size()).isEqualTo(3);
        assertThat(s.getAddCount()).isEqualTo(3);
    }

}