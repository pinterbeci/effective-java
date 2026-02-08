package hu.pinterbeci.effective.java.chapter3.item10;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CaseInsensitiveStringTest {


    @Test
    void should_represent_symmetry_violation() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        //it violates the symmetry with one-way interoperability
        //this must be 'false'
        assertThat(cis.violatesSymmetryEquals(s)).isTrue();

        //the other side of the symmetry does not complete
        assertThat(s.equals(cis)).isFalse();

        List<CaseInsensitiveString> caseInsensitiveStringList = List.of(cis);
        //does not work
        //assertThat(caseInsensitiveStringList).doesNotContain(s);
    }

    @Test
    void should_investigate_case_sensitivity() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        assertThat(cis.equals(s)).isFalse();
    }

    @Test
    void should_find_symmetry() {
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        //have no two-side case sensitivity
        assertThat(s.equals(cis)).isFalse();
    }
}