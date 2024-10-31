package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class 자연수뒤집어배열로만들기Test {

    public int[] solution(String n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        String reverse = stringBuilder.reverse().toString();

        char[] arr = reverse.toCharArray();

        int[] result = new int[n.length()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i] - '0';
        }

        return result;
    }

    @Test
    void result() {
        int[] solution = solution("12345");
        int[] result = {5, 4, 3, 2, 1};

        assertThat(solution).isEqualTo(result);
        assertThat(solution.length).isEqualTo(5);
    }
}
