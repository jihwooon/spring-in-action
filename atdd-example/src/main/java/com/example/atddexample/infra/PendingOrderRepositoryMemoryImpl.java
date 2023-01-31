package com.example.atddexample.infra;

import com.example.atddexample.domain.PendingOrder;
import com.example.atddexample.domain.PendingOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {
    private final AtomicLong atomicLong = new AtomicLong(1);

    @Override
    public PendingOrder save(final PendingOrder pendingOrder) {
        pendingOrder.assignId(nextId());
        return pendingOrder;
    }

    private long nextId() {
        return atomicLong.getAndIncrement();
    }
}
