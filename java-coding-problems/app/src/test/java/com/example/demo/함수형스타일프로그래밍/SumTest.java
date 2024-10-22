package com.example.demo.함수형스타일프로그래밍;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class SumTest {

    @Test
    void sumMelons() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        int sum = melons.stream()
                .mapToInt(Melon::getWeight)
                .sum();

        assertThat(sum).isEqualTo(19500);
    }

    @Test
    void maxMelons() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        int maxOfWeight = melons.stream()
                .mapToInt(Melon::getWeight)
                .max()
                .orElse(-1);

        assertThat(maxOfWeight).isEqualTo(3000);
    }

    @Test
    void minMelons() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        int minOfMelon = melons.stream()
                .mapToInt(Melon::getWeight)
                .min()
                .orElse(-1);

        assertThat(minOfMelon).isEqualTo(1200);
    }
}
