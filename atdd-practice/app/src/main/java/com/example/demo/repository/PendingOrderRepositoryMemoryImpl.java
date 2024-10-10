package com.example.demo.repository;

import com.example.demo.domain.PendingOrder;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Repository;

@Repository
public class PendingOrderRepositoryMemoryImpl implements
        PendingOrderRepository {

    private final AtomicLong atomicId = new AtomicLong(1);

    @Override
    public PendingOrder save(PendingOrder pendingOrder) {
        pendingOrder.assignId(nextId());
        return pendingOrder;
    }

    private long nextId() {
        return atomicId.getAndIncrement();
    }
}
