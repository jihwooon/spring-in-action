package com.example.demo.application;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PendingOrderRequest {

    private long productId;
    private int quantity;

    public PendingOrderRequest(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(long productId, int quantity) {
        return new PendingOrderRequest(productId, quantity);
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
