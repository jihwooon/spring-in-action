package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;
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

    public PendingOrderResponse(final PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }
}
