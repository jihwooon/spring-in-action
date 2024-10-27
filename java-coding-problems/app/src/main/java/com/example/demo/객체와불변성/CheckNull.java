package com.example.demo.객체와불변성;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CheckNull {

    public List<Integer> evenInteger(List<Integer> integers) {
        if (Objects.isNull(integers)) {
            throw new IllegalStateException("null이 발생했습니다.");
        }

        List<Integer> even = new ArrayList<>();
        for (Integer nr : integers) {
            if (Objects.nonNull(nr) && nr % 2 == 0) {
                even.add(nr);
            }
        }

        return even;
    }

    public int sumIntegers(List<Integer> integers) {
        if (Objects.isNull(integers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }

}
