package com.example.demo.함수형스타일;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class FiltersTest {

    @Test
    void returnResult() {
        List<Integer> list = Arrays.asList(1, 13, 15, 2, 67);
        List<Integer> filter = Filters.filter(list, (Integer i) -> i < 10);

        assertThat(filter).isEqualTo(List.of(1, 2));
    }
}
