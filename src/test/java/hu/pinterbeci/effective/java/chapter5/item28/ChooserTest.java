package hu.pinterbeci.effective.java.chapter5.item28;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ChooserTest {

    @Test
    void should_choose() {
        assertDoesNotThrow(() -> {
            Chooser<Integer> chooser = new Chooser<>(List.of(2, 7, 0));
            chooser.choose();
        });
    }
}