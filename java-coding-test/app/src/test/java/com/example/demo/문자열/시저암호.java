package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 시저암호 {

    public String solution(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (char arr : s.toCharArray()) {
            builder.append(push(arr, n));
        }

        return builder.toString();
    }

    private char push(char c, int n) {
        if (!Character.isAlphabetic(c)) {
            return c;
        }

        char offset = Character.isUpperCase(c) ? 'A' : 'a';
        int position = c - offset;
        position = (position + n) % ('Z' - 'A' + 1);

        return (char) (offset + position);

    }

    @Test
    void result() {
        String result = solution("AB", 1);

        assertThat(result).isEqualTo("BC");
    }
}
