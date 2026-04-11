package hu.pinterbeci.effective.java.chapter7.item45;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static hu.pinterbeci.effective.java.chapter7.item45.Anagrams.findAnagramsByLimit;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AnagramsTest {

    @Test
    public void should_find_anagrams() {
        final List<String> words = List.of("bac", "cba", "bca", "tre", "ret", "opo");
        final Map<String, List<String>> expected = Map.of(
                "abc", List.of("bac", "cba", "bca"),
                "ert", List.of("tre", "ret")
        );

        final Map<String, List<String>> actual = findAnagramsByLimit(words, 1);
        assertThat(actual).isEqualTo(expected);
    }
}
