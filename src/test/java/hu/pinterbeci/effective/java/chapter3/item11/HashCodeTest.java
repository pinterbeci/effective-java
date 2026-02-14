package hu.pinterbeci.effective.java.chapter3.item11;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class HashCodeTest {
    @Test
    void should_expect_same_values_from_map() {
        Map<PhoneNumber, String> namesByPhoneNumber = new HashMap<>();
        namesByPhoneNumber.put(new PhoneNumber(707, 867, 5309), "Jenny");

        assertThat(
                namesByPhoneNumber.get(
                        new PhoneNumber(707, 867, 5309)
                )
        ).isEqualTo("Jenny");
    }

    @Test
    void should_test_hashCode_contract() {
        PhoneNumber firstPhoneNumber = new PhoneNumber(707, 867, 5309);
        int hashCodeOfPhoneNumber = firstPhoneNumber.hashCode();

        //1. when the hashCode method is invoked on an object repeatedly during an execution of an application
        //  it must consistently return the same value.
        for (int i = 0; i < 5; i++) {
            assertThat(firstPhoneNumber.hashCode()).isEqualTo(hashCodeOfPhoneNumber);
        }

        //2. if two objects are equal according the equals method, then calling the hashCode on two objects
        // must produce the same integer

        PhoneNumber secondPhoneNumber = new PhoneNumber(707, 867, 5309);
        assertThat(secondPhoneNumber.equals(firstPhoneNumber)).isTrue();
        assertThat(secondPhoneNumber.hashCode()).isEqualTo(hashCodeOfPhoneNumber);

        //3. if two objects are unequal according the equals method, it is not required to call the hashCode method
        PhoneNumber thirdPhoneNumber = new PhoneNumber(707, 867, 5310);
        assertThat(thirdPhoneNumber.equals(firstPhoneNumber)).isFalse();

    }
}