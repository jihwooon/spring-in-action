package com.example.demo.문자열과수;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 참조매개변수Test {

    @Test
    void runReference() {
        Data2 data = new Data2();
        data.x = 10;

        assertThat(data.x).isEqualTo(10);

        int change = data.change(data);
        assertThat(change).isEqualTo(1000);

        assertThat(data.x).isEqualTo(1000);
    }
}
