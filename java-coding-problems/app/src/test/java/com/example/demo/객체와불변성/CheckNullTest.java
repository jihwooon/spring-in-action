package com.example.demo.객체와불변성;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class CheckNullTest {

    @Test
    void checkIfisNull() {
        CheckNull checkNull = new CheckNull();

        assertThatThrownBy(
                () -> checkNull.evenInteger(null)
        ).hasMessage("null이 발생했습니다.");
    }

    @Test
    void checkIfNotNull() {
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);

        CheckNull checkNull = new CheckNull();

        assertThat(checkNull.evenInteger(numbers)).isEqualTo(List.of(2, 4, 16));
    }

    @Test
    void checkSumIfNull() {
        CheckNull checkNull = new CheckNull();

        assertThatThrownBy(
                () -> checkNull.sumIntegers(null)
        ).hasMessage("List cannot be null");
    }

    @Test
    void checkSumIfNotNull() {
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, null, 16, 7, null);

        CheckNull checkNull = new CheckNull();

        assertThat(checkNull.sumIntegers(numbers)).isEqualTo(30);
    }
}
