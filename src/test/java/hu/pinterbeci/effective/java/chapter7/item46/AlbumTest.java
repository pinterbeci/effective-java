package hu.pinterbeci.effective.java.chapter7.item46;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toMap;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class AlbumTest {
    private List<Album> albums;
    private Album adeleTopHit;
    private Album beatlesTopHit;
    private Album pinkFloydTopHit;

    @Before
    public void setUp() {

        adeleTopHit = new Album("Adele", "21", 2011, 31_000_000L, "Pop");
        beatlesTopHit = new Album("Beatles", "Abbey Road", 1969, 14_000_000L, "Rock");
        pinkFloydTopHit = new Album("Pink Floyd", "The Dark Side of the Moon", 1973, 45_000_000L, "Rock");

        albums = List.of(
                beatlesTopHit,
                new Album("Beatles", "Let It Be", 1970, 5_000_000L, "Rock"),
                adeleTopHit,
                new Album("Adele", "25", 2015, 20_000_000L, "Pop"),
                pinkFloydTopHit,
                new Album("Pink Floyd", "The Wall", 1979, 30_000_000L, "Rock")
        );
    }

    /**
     * important:  there is never a reason to say collect(counting())
     * instead of this: summing, averaging, and summarizing
     */
    @Test
    public void should_find_topHits() {
        var expected = Map.of(
                "Adele", adeleTopHit,
                "Beatles", beatlesTopHit,
                "Pink Floyd", pinkFloydTopHit
        );
        final Map<String, Album> actual = albums.stream()
                .collect(toMap(
                                album -> album.artist(),
                                album -> album,
                                (x, y) -> {
                                    final Comparator<Album> cmp = new Comparator<Album>() {
                                        @Override
                                        public int compare(Album o1, Album o2) {
                                            return Long.compare(o1.sales(), o2.sales());
                                        }
                                    };
                                    return cmp.compare(x, y) >= 0 ? x : y;
                                }
                        )
                );
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void should_count_words_appearance() {
        var expected = Map.of(
                "aaa", 2,
                "ae", 2,
                "p", 1
        );

        final List<String> strings = List.of("aaa", "aaa", "ae", "ae", "p");
        var actual = strings.stream()
                .collect(
                        //upstream
                        groupingBy(
                                s -> s,
                                //downstream
                                summingInt(s -> 1)
                        )
                );

        assertThat(actual).isEqualTo(expected);
    }
}