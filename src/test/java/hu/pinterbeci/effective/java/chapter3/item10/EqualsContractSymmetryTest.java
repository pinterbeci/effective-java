package hu.pinterbeci.effective.java.chapter3.item10;

import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Timestamp;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EqualsContractSymmetryTest {
    @Test
    void should_violates_equals_contract_symmetry_with_timestamp_and_date() {
        long now = System.currentTimeMillis();

        Date date = new Date(now);
        Timestamp timestamp = new Timestamp(now);

        timestamp.setNanos((int) (now % 1000) * 1_000_000);

        assertThat(date.equals(timestamp)).isTrue();
        assertThat(timestamp.equals(date)).isFalse();
    }
}
