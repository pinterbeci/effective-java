package hu.pinterbeci.effective.java.chapter7.item45;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SetLookupTest {

    private List<String> listA;
    private List<String> listB;

    @Before
    public void setUp() {
        listA = List.of(
                "apple", "banana", "cherry", "date", "elderberry",
                "fig", "grape", "honeydew", "kiwi", "lemon",
                "mango", "nectarine", "orange", "papaya", "quince",
                "raspberry", "strawberry", "tangerine", "ugli", "vanilla",
                "watermelon", "xigua", "yellowfruit", "zucchini", "apricot",
                "blueberry", "cantaloupe", "dragonfruit", "eucalyptus", "feijoa",
                "guava", "hackberry", "ilama", "jujube", "kumquat",
                "lime", "mulberry", "nonpareil", "olive", "peach",
                "plum", "pomegranate", "rambutan", "salak", "tamarind",
                "ugni", "voavanga", "wampee", "ximenia", "yuzu"
        );

        listB = List.of(
                "banana", "cherry", "grape", "kiwi", "mango",
                "orange", "raspberry", "strawberry", "watermelon", "apricot",
                "blueberry", "dragonfruit", "guava", "jujube", "kumquat",
                "lime", "peach", "plum", "pomegranate", "tamarind",
                "coconut", "durian", "gooseberry", "jackfruit", "longan",
                "lychee", "mandarin", "pawpaw", "persimmon", "pineapple",
                "pitaya", "plantain", "sapodilla", "soursop", "starfruit",
                "sweetsop", "tangelo", "tomato", "turnip", "avocado",
                "blackberry", "boysenberry", "breadfruit", "carambola", "cherimoya",
                "clementine", "cloudberry", "crabapple", "cranberry", "currant"
        );
    }

    @Test
    public void should_compare_nested_loops_to_set_lookup() {
        final List<String> commonStrings = new ArrayList<>();

        final long nestedLoopsBegin = System.nanoTime();
        for (String elementFromA : listA) {
            for (String elementFromB : listB) {
                if (elementFromA.equals(elementFromB)) {
                    commonStrings.add(elementFromA);
                }
            }
        }
        final long nestedLoopsEnd = System.nanoTime();


        //set lookup
        final long setLookupBegin = System.nanoTime();

        final Set<String> setLookup = new HashSet<>(listB);
        final List<String> commonStrings2 = new ArrayList<>();

        for (String elementFromA : listA) {
            if (setLookup.contains(elementFromA))
                commonStrings2.add(elementFromA);
        }
        final long setLookupEnd = System.nanoTime();


        final long setLookupExecution = setLookupEnd - setLookupBegin;
        final long nestedLoopsExecution = nestedLoopsEnd - nestedLoopsBegin;

        System.out.println("set lookup execution time: " + setLookupExecution);
        System.out.println("nested loops execution time: " + nestedLoopsExecution);

        assertThat(setLookupExecution).isLessThanOrEqualTo(nestedLoopsExecution);

    }
}
