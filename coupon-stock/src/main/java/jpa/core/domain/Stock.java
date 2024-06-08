package jpa.core.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jpa.core.exception.InvalidStockValueException;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long productId;

    private long quantity;

    @Version
    private Long version;

    public Stock() {
    }

    public Stock(final Long productId, final long quantity) {
        ensureValidStock(quantity);

        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void decrease(final long quantity) {
        ensureValidStock(quantity);

        this.quantity -= quantity;
    }

    private static void ensureValidStock(final long quantity) {
        if (quantity < 1L) {
            throw new InvalidStockValueException("남은 재고가 없습니다.");
        }
    }
}
