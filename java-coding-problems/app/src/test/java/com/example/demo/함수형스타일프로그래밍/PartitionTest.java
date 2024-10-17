package com.example.demo.함수형스타일프로그래밍;

import static java.util.stream.Collectors.partitioningBy;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PartitionTest {

    @Test
    @DisplayName("멜론 목록을 무게가 2000그램을 초과하는지 여부에 따라 그룹화하면 각 그룹에 대한 멜론 목록을 반환한다.")
    void partitionMelonsByWeight() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Map<Boolean, List<Melon>> collect = melons.stream()
                .collect(partitioningBy(m -> m.getWeight() > 2000));

        assertThat(collect).isEqualTo(Map.of(
                true, Arrays.asList(
                        new Melon("Gac", 3000),
                        new Melon("Hemi", 2600),
                        new Melon("Apollo", 2600),
                        new Melon("Gac", 3000),
                        new Melon("Hemi", 2600)),
                false, Arrays.asList(
                        new Melon("Crenshaw", 1200),
                        new Melon("Hemi", 1600),
                        new Melon("Gac", 1200),
                        new Melon("Horned", 1700)
                )));
    }
}
