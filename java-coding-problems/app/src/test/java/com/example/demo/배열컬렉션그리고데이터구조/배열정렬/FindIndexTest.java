package com.example.demo.배열컬렉션그리고데이터구조.배열정렬;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.배열컬렉션그리고데이터구조.Melon;
import java.util.Comparator;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FindIndexTest {

    Melon[] melons;
    Comparator<Melon> byWeight;

    @BeforeEach
    void setUp() {
        melons = new Melon[]{
                new Melon("Horned", 1500),
                new Melon("Gac", 1000)
        };

        byWeight = Comparator.comparing(Melon::getWeight);
    }

    @Test
    void findIndexOfElementObjectV1() {
        int objectV1 = findIndexOfElementObjectV1(melons,
                new Melon("Hami", 1500),
                byWeight);

        assertThat(objectV1).isEqualTo(0);
    }

    @Test
    void findIndexOfElementObjectV2() {
        int objectV2 = findIndexOfElementObjectV2(melons,
                new Melon("Hami", 1500),
                byWeight);

        assertThat(objectV2).isEqualTo(0);
    }

    public static <T> int findIndexOfElementObjectV1(T[] arr, T toFind,
            Comparator<? super T> c) {
        for (int i = 0; i < arr.length; i++) {
            if (c.compare(arr[i], toFind) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static <T> int findIndexOfElementObjectV2(T[] arr, T toFind,
            Comparator<? super T> c) {
        return IntStream.range(0, arr.length)
                .filter(i -> c.compare(toFind, arr[i]) == 0)
                .findFirst()
                .orElse(-1);
    }
}
