package com.example.demo.문자열과수;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class 문자개수세기Test {

    @Test
    void count() {
        문자개수세기 result = new 문자개수세기();

        Map<Character, Integer> count = result.countCharacterOccurrences(
                "aabbcccc");

        assertThat(count.get('a')).isEqualTo(2L);
        assertThat(count.get('b')).isEqualTo(2L);
        assertThat(count.get('c')).isEqualTo(4L);
    }

    @Test
    void countStream() {
        문자개수세기 result = new 문자개수세기();

        Map<Character, Long> count = result.countCharacterOccurrencesWithStream(
                "aabbcccc");

        assertThat(count.get('a')).isEqualTo(2L);
        assertThat(count.get('b')).isEqualTo(2L);
        assertThat(count.get('c')).isEqualTo(4L);
    }
}
