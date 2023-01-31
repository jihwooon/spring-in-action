package com.example.atddexample.application;

import lombok.Getter;

@Getter
public class PendingOrderResponse {
    private long id;
    private long productId;
    private int quantity;

    public PendingOrderResponse(final long productId, final int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
