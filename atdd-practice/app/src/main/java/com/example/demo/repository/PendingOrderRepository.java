package com.example.demo.repository;

import com.example.demo.domain.PendingOrder;

public interface PendingOrderRepository {

    PendingOrder save(PendingOrder pendingOrder);
}
