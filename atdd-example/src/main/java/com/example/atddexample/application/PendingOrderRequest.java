package com.example.atddexample.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private int quantity;

    public static PendingOrderRequest of(final long productId, final int quantity) {
        throw  new UnsupportedOperationException("PendingOrderRequest not Implemented yet !!");
    }
}
