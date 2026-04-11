package hu.pinterbeci.effective.java.chapter7.item45;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Anagrams {

    /**
     * toMap with merge VS groupingBy:
     * 1.:
     * // toMap — reader must mentally simulate what this does
     * toMap(String::toLowerCase, w -> 1L, (a, b) -> a + b)
     * // groupingBy — reader immediately knows what this does
     * groupingBy(String::toLowerCase, counting())
     *
     *2.:
     * toMap throws on null, groupingBy doesn't
     *
     * 3.:
     * groupingBy never produces empty group
     */

    public static Map<String, List<String>> findAnagramsByLimit(final List<String> dictionary, final int limit) {
        return dictionary
                .stream()
                .collect(groupingBy(Anagrams::alphabetize))
                .entrySet()
                .stream()
                .filter(anagramGroup -> anagramGroup.getValue().size() > limit)
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue
                        )
                );
    }

    private static String alphabetize(final String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
