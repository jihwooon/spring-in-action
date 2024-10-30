package com.example.demo.객체와불변성;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void checkNullPointException() {
        assertThatThrownBy(() -> new Car(null, "빨강"))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Car name cannot be null");

        assertThatThrownBy(() -> new Car("차", null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Car color cannot be null");

        assertThatThrownBy(() -> new Car(null, null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Both name, color cannot be null");
    }
}
