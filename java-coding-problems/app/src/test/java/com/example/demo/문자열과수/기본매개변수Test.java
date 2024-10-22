package com.example.demo.문자열과수;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 기본매개변수Test {

    @Test
    void runValue() {
        Data data = new Data();
        data.x = 10;

        assertThat(data.x).isEqualTo(10);

        int change = data.change(data.x);

        assertThat(change).isEqualTo(1000);

        assertThat(data.x).isEqualTo(10);
    }
}
