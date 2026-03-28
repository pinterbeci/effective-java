package hu.pinterbeci.effective.java.chapter6.item37;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PlantTest {

    private static List<Plant> garden;

    @BeforeAll
    public static void setUp() {
        garden = List.of(
                new Plant("test-flower-1", Plant.LifeCycle.PERENNIAL),
                new Plant("test-flower-2", Plant.LifeCycle.PERENNIAL),
                new Plant("test-flower-3", Plant.LifeCycle.PERENNIAL),
                new Plant("test-flower-4", Plant.LifeCycle.BIENNIAL),
                new Plant("test-flower-5", Plant.LifeCycle.BIENNIAL),
                new Plant("test-flower-6", Plant.LifeCycle.ANNUAL),
                new Plant("test-flower-7", Plant.LifeCycle.ANNUAL)
        );
    }

    @Test
    void should_make_a_garden_by_lifecycle_and_print_it_with_unchecked_assigment_warning() {
        assertDoesNotThrow(() -> {
            final Set<Plant>[] plantsByLifeCycle =
                    //relies on array as a reifiable type, they know and enforce their element type, BUT
                    // if the element type is a generic (which loose the parameter type in runtime, regarding
                    //the type erasure) and compiler shows a warning:
                    //unchecked assignment: 'java.util.Set[]' to 'java.util.Set<Plant>[}
                    new Set[Plant.LifeCycle.values().length];
            for (int i = 0; i < plantsByLifeCycle.length; i++)
                plantsByLifeCycle[i] = new HashSet<>();
            for (Plant p : garden)
                //the `ordinal` could change, if the enum elements orders changes, eliminate this!!!!!!!!!!!!!
                plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
            for (int i = 0; i < plantsByLifeCycle.length; i++) {
                System.out.printf("%s: %s%n",
                        Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
            }
        });
    }

    @Test
    void should_make_a_garden_by_lifecycle_and_print_it_with_unchecked_cast_warning() {
        assertDoesNotThrow(() -> {
            final Set<Plant>[] plantsByLifeCycle =
                    //and then I forced a cast, but the compiler shows a warning:
                    //Unchecked cast: 'java.util.Set[]' to 'java.util.Set<Plant>[]
                    (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
            for (int i = 0; i < plantsByLifeCycle.length; i++)
                plantsByLifeCycle[i] = new HashSet<>();
            for (Plant p : garden)
                //the `ordinal` could change, if the enum elements orders changes, eliminate this!!!!!!!!!!!!!
                plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
            for (int i = 0; i < plantsByLifeCycle.length; i++) {
                System.out.printf("%s: %s%n",
                        Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
            }
        });
    }

    @Test
    void should_make_a_garden_by_lifecycle_and_print_it_without_warning_and_without_unsafe_ordinal() {
        assertDoesNotThrow(() -> {
            final Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

            for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
                plantsByLifeCycle.put(lc, new HashSet<>());
            }
            for (Plant p : garden) {
                plantsByLifeCycle.get(p.lifeCycle).add(p);
            }
            System.out.println(plantsByLifeCycle);
        });
    }


    /**
     * So, for example, if the garden contains annuals and perennials but no biennials, the size of plantsByLifeCycle will
     * be three in the EnumMap version and two in both of the stream-based versions
     */
    @Test
    void should_make_a_garden_by_lifecycle_and_print_it_without_warning_and_without_unsafe_ordinal_with_stream() {

        assertDoesNotThrow(() -> System.out.println(
                garden.stream()
                        .collect(groupingBy(p -> p.lifeCycle, () -> new EnumMap<>(Plant.LifeCycle.class), toSet()))
        ));
    }
}