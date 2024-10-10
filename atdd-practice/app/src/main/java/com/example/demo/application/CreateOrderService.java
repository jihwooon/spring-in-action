package com.example.demo.application;

import com.example.demo.domain.PendingOrder;

public interface CreateOrderService {

    PendingOrder createPendingOrder(PendingOrderRequest request);
}
