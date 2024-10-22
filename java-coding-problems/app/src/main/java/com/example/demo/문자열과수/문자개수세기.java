package com.example.demo.문자열과수;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class 문자개수세기 {

    private Map<Character, Integer> countDuplicateCharacters = new HashMap<>();

    public Map<Character, Integer> countCharacterOccurrences(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            countDuplicateCharacters.compute(c,
                    (k, v) -> (v == null) ? 1 : v + 1);
        }

        System.out.println(countDuplicateCharacters);

        return countDuplicateCharacters;
    }

    public Map<Character, Long> countCharacterOccurrencesWithStream(String str) {
        Map<Character, Long> collect = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return collect;
    }

}
