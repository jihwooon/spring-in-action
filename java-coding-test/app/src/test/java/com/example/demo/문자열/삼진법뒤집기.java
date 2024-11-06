package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 삼진법뒤집기 {

    public int solution(int n) {
        String ternaryScale = Integer.toString(n, 3);

        String reversed = new StringBuilder().append(ternaryScale).reverse()
                .toString();

        return Integer.valueOf(reversed, 3);
    }

    @Test
    void result() {
        assertThat(solution(45)).isEqualTo(7);
        assertThat(solution(125)).isEqualTo(229);
    }
}
