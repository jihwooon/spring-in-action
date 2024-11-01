package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 이상한문자만들기 {

    public String solution(String s) {
        StringBuilder builder = new StringBuilder();
        boolean toUpper = true;

        for (char c : s.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                builder.append(c);
                toUpper = true;
            } else {
                if (toUpper) {
                    builder.append(Character.toUpperCase(c));
                } else {
                    builder.append(Character.toLowerCase(c));
                }
                toUpper = !toUpper;
            }
        }

        return builder.toString();
    }

    @Test
    void result() {
        String result = solution("try hello world");

        assertThat(result).isEqualTo("TrY HeLlO WoRlD");
    }
}
