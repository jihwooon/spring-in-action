package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;
import com.example.atddexample.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
class CreateOrderServiceImp implements CreateOrderService {
    private final PendingOrderRepository pendingOrderRepository;

    CreateOrderServiceImp(final PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(final PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }
}
