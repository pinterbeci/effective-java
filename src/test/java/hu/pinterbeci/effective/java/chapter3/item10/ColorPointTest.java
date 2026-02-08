package hu.pinterbeci.effective.java.chapter3.item10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ColorPointTest {

    @Test
    void should_violates_symmetry() {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        //violates the symmetry
        assertThat(p.equals(cp)).isTrue();
        assertThat(cp.violatesSymmetryEquals(p)).isFalse();
    }

    @Test
    void should_violates_the_transitivity() {
        ColorPoint cp1 = new ColorPoint(1, 2, Color.RED);
        Point p = new Point(1, 2);
        ColorPoint cp2 = new ColorPoint(1, 2, Color.BLUE);

        assertThat(cp1.equals(p)).isTrue();
        assertThat(p.equals(cp2)).isTrue();
        //violates transitivity
        assertThat(cp2.equals(cp1)).isFalse();
    }

    @Test
    void should_causes_stack_overflow() {
        assertThatThrownBy(() -> {
            SmellPoint smellPoint = new SmellPoint(1, 2, Color.BLUE);
            ColorPoint colorPoint = new ColorPoint(1, 2, Color.PURPLE);
            smellPoint.equals(colorPoint);
        }).isInstanceOf(StackOverflowError.class);
    }
}