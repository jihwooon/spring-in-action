package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 자릿수더하기 {

    private int solution(int n) {
        int answer = 0;

        while (n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

    @Test
    void result() {
        assertThat(solution(123)).isEqualTo(6);
    }
}
