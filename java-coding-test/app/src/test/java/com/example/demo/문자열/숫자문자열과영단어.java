package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 숫자문자열과영단어 {

    public int solution(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};

        for (int i = 0; i < words.length; i++) {
            s = s.replaceAll(words[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    @Test
    void result() {
        assertThat(solution("one4seveneight")).isEqualTo(1478);
    }
}
