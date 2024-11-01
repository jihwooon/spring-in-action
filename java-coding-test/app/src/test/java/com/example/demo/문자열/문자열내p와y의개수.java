package com.example.demo.문자열;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class 문자열내p와y의개수 {

    boolean solution(String s) {
        String lowerCase = s.toLowerCase();

        int p = getP(lowerCase, "p");
        int y = getY(lowerCase, "y");

        return p == y;
    }

    private int getY(String lowerCase, String y) {
        return lowerCase.length() - lowerCase.replace(y, "").length();
    }

    private int getP(String lowerCase, String p) {
        return lowerCase.length() - lowerCase.replace(p, "").length();
    }

    @Test
    void result() {
        assertThat(solution("PPoooyY")).isTrue();
    }
}
