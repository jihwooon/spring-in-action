package com.example.demo.함수형스타일프로그래밍;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ReduceTest {

    @Test
    void reduceSum() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Integer totalWeight = melons.stream()
                .map(Melon::getWeight)
                .reduce((a, b) -> a + b)
                .orElse(-1);

        assertThat(totalWeight).isEqualTo(19500);
    }

    @Test
    void reduceMax() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Integer totalWeight = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::max)
                .orElse(-1);

        assertThat(totalWeight).isEqualTo(3000);
    }

    @Test
    void reduceMin() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Integer totalWeight = melons.stream()
                .map(Melon::getWeight)
                .reduce(Integer::min)
                .orElse(-1);

        assertThat(totalWeight).isEqualTo(1200);
    }
}
