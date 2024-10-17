package com.example.demo.함수형스타일프로그래밍;

import static com.example.demo.함수형스타일프로그래밍.Melon.Sugar.HIGH;
import static com.example.demo.함수형스타일프로그래밍.Melon.Sugar.LOW;
import static com.example.demo.함수형스타일프로그래밍.Melon.Sugar.MEDIUM;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.함수형스타일프로그래밍.Melon.Sugar;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GroupByTest {

    @Test
    @DisplayName("멜론 목록을 무게별로 그룹화하면 각 무게에 대한 멜로의 종류를 반환한다.")
    void groupMelonsByWeight() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Map<Integer, List<Melon>> byTypeInList = melons.stream()
                .collect(groupingBy(Melon::getWeight));

        assertThat(byTypeInList).isEqualTo(Map.of(
                1200, Arrays.asList(new Melon("Crenshaw", 1200),
                        new Melon("Gac", 1200)),
                3000,
                Arrays.asList(new Melon("Gac", 3000), new Melon("Gac", 3000)),
                2600, Arrays.asList(new Melon("Hemi", 2600),
                        new Melon("Apollo", 2600), new Melon("Hemi", 2600)),
                1600, Arrays.asList(new Melon("Hemi", 1600)),
                1700, Arrays.asList(new Melon("Horned", 1700))
        ));
    }

    @Test
    @DisplayName("멜론 목록을 무게별로 그룹화하면 각 무게에 대한 멜로의 수를 반환한다.")
    void countMelonsByWeight() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200),
                new Melon("Gac", 3000), new Melon("Hemi", 2600),
                new Melon("Hemi", 1600), new Melon("Gac", 1200),
                new Melon("Apollo", 2600), new Melon("Horned", 1700),
                new Melon("Gac", 3000), new Melon("Hemi", 2600)
        );

        Map<Integer, Long> typesCount = melons.stream()
                .collect(groupingBy(Melon::getWeight, counting()));

        assertThat(typesCount).isEqualTo(Map.of(
                1200, 2L, 1600, 1L, 1700, 1L, 2600, 3L, 3000, 2L));
    }

    @Test
    @DisplayName("멜론 목록을 당도와 무게별로 그룹화하면 각 그룹에 대한 멜론의 종류를 반환한다")
    void groupMelonsBySugarAndWeight() {
        List<Melon> melons = Arrays.asList(new Melon("Crenshaw", 1200, HIGH),
                new Melon("Gac", 3000), new Melon("Hemi", 2600, HIGH),
                new Melon("Hemi", 1600), new Melon("Gac", 1200, LOW),
                new Melon("Apollo", 2600), new Melon("Horned", 1700, MEDIUM),
                new Melon("Gac", 3000), new Melon("Hemi", 2600, MEDIUM)
        );

        Map<Sugar, TreeMap<Integer, Set<String>>> bySugarAndWeight = melons.stream()
                .collect(groupingBy(Melon::getSugar, groupingBy(
                        Melon::getWeight, TreeMap::new,
                        mapping(Melon::getType, toSet())
                )));

        assertThat(bySugarAndWeight).isEqualTo(Map.of(
                Sugar.HIGH, new TreeMap<>(Map.of(
                        1200, Set.of("Crenshaw"),
                        2600, Set.of("Hemi")
                )),
                Sugar.LOW, new TreeMap<>(Map.of(
                        1200, Set.of("Gac")
                )),
                Sugar.MEDIUM, new TreeMap<>(Map.of(
                        1700, Set.of("Horned"),
                        2600, Set.of("Hemi")
                )),
                Sugar.UNKONWN, new TreeMap<>(Map.of(
                        3000, Set.of("Gac"),
                        1600, Set.of("Hemi"),
                        2600, Set.of("Apollo")
                ))
        ));
    }
}
