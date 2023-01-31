package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;

public interface CreateOrderService {
    PendingOrder createPendingOrder(PendingOrderRequest request);
}
