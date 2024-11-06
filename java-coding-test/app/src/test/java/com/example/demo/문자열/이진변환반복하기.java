package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 이진변환반복하기 {

    public int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        while (!s.equals("1")) {
            int counts = zeroCount(s);
            loop += 1;
            removed += counts;

            s = changeStringToBinary(s, counts);
        }

        return new int[]{loop, removed};
    }

    private String changeStringToBinary(String s, int zeroCount) {
        int ones = s.length() - zeroCount;
        s = Integer.toString(ones, 2);
        return s;
    }

    private int zeroCount(String source) {
        int zero = 0;

        for (char c : source.toCharArray()) {
            if (c == '0') {
                zero++;
            }
        }

        return zero;
    }

    @Test
    void result() {
        assertThat(solution("01110")).isEqualTo(new int[]{3, 3});
    }
}
