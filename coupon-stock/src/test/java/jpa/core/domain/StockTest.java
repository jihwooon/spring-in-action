package jpa.core.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import jpa.core.exception.InvalidStockValueException;
import org.junit.jupiter.api.Test;

class StockTest {

    @Test
    public void success_of() {
        Stock stock = new Stock(1L, 100L);

        assertThat(stock.getQuantity()).isEqualTo(100);
    }

    @Test
    void decrease() {
        Stock stock = new Stock(1L, 100L);
        stock.decrease(1L);

        assertThat(stock.getQuantity()).isEqualTo(99);
    }

    @Test
    void decreaseLessThenZero() {
        Stock stock = new Stock(1L, 1L);

        assertThrows(InvalidStockValueException.class, () -> stock.decrease(0L));
    }
}
