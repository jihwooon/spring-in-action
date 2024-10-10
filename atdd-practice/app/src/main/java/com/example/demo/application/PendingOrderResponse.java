package com.example.demo.application;

import com.example.demo.domain.PendingOrder;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PendingOrderResponse {

    private long id;
    private long productId;
    private int quantity;

    protected PendingOrderResponse() {
    }

    public PendingOrderResponse(PendingOrder pendingOrder) {
        this.id = pendingOrder.getId();
        this.productId = pendingOrder.getProductId();
        this.quantity = pendingOrder.getQuantity();
    }

    public long getId() {
        return id;
    }

    public long getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
