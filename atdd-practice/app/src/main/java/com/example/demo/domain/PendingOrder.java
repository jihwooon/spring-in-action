package com.example.demo.domain;

public class PendingOrder {

    private long id;
    private long productId;
    private int quantity;

    public PendingOrder(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
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

    public void assignId(long nextId) {
        this.id = nextId;
    }
}
