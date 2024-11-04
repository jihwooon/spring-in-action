package com.example.demo.재귀;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class 모음사전 {

    private static final char[] CHARS = "AEIOU".toCharArray();

    public List<String> generate(String word) {
        List<String> words = new ArrayList<>();
        words.add(word);

        if (word.length() == 5) {
            return words;
        }

        for (char c : CHARS) {
            words.addAll(generate(word + c));
        }

        return words;
    }

    private int solution(String word) {
        return generate("").indexOf(word);
    }

    @Test
    void result() {
        assertThat(solution("AAAAE")).isEqualTo(6);
    }
}
