package com.example.demo.객체와불변성;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Player Class")
class PlayerTest {

    @Test
    @DisplayName("두 객체가 동일하면 테스트한다.")
    void equalObject() {
        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");

        assertThat(p1).isEqualTo(p2);
    }

    @Test
    @DisplayName("자바 해쉬값이 동일하면 테스트를 통과한다.")
    void hashObject() {
        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");

        HashSet<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);

        assertThat(players.size()).isEqualTo(1);
        assertThat(p1.hashCode()).isEqualTo(p2.hashCode());
    }

    @Test
    @DisplayName("자바 해쉬값이 동일하지 않으면 테스트를 통과한다.")
    void hashIsNotEqualObject() {
        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(2, "Nadl");

        HashSet<Player> players = new HashSet<>();
        players.add(p1);
        players.add(p2);

        assertThat(players.size()).isEqualTo(2);
        assertThat(p1.hashCode()).isNotEqualTo(p2.hashCode());
    }
}
