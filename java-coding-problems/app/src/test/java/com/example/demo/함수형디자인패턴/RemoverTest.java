package com.example.demo.함수형디자인패턴;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.함수형디자인패턴.전략패턴.Remover;
import org.junit.jupiter.api.Test;

class RemoverTest {

    @Test
    void removeWhitespace() {
        String thisIsAText = Remover.remove("this is a text",
                s -> s.replaceAll("\\s", ""));

        assertThat(thisIsAText).isEqualTo("thisisatext");
    }

    @Test
    void removeNumber() {
        String thisIsAText = Remover.remove("this is a text213",

                s -> s.replaceAll("\\d", ""));

        assertThat(thisIsAText).isEqualTo("this is a text");
    }
}
