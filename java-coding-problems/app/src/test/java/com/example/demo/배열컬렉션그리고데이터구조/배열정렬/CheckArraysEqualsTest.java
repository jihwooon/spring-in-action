package com.example.demo.배열컬렉션그리고데이터구조.배열정렬;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.배열컬렉션그리고데이터구조.Melon;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.jupiter.api.Test;

class CheckArraysEqualsTest {

    @Test
    void checkArraysEquals() {
        int[] integers1 = new int[]{3, 4, 5, 6, 1, 5};
        int[] integers2 = new int[]{3, 4, 5, 6, 1, 5};
        int[] integers3 = new int[]{3, 4, 5, 6, 1, 3};

        assertThat(Arrays.equals(integers1, integers2)).isTrue();
        assertThat(Arrays.equals(integers1, integers3)).isFalse();
    }

    @Test
    void checkArrayByObject() {
        Melon[] melons1 = new Melon[]{new Melon("Horned", 1500),
                new Melon("Gac", 1000)};
        Melon[] melons2 = new Melon[]{new Melon("Horned", 1500),
                new Melon("Gac", 1000)};
        Melon[] melons3 = new Melon[]{new Melon("Hami", 1500),
                new Melon("Gac", 1000)};

        assertThat(Arrays.equals(melons1, melons2)).isTrue();
        assertThat(Arrays.equals(melons1, melons3)).isFalse();

        assertThat(Arrays.mismatch(melons1, melons2)).isEqualTo(-1);

        assertThat(Arrays.mismatch(melons1, 1, 2, melons3, 1, 2)).isEqualTo(-1);

        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);
        assertThat(Arrays.mismatch(melons2, melons3, byWeight)).isEqualTo(-1);
    }
}
