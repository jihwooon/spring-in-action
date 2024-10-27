package com.example.demo.문자열과수;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class UtilTest {

    @Test
    void name() {
        int compare = Util.compare(10, 11);

        assertThat(compare).isEqualTo(-1);
    }
}
