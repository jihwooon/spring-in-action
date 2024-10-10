package com.example.demo.application;

import com.example.demo.domain.PendingOrder;
import com.example.demo.repository.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderServiceImp implements CreateOrderService {

    private final PendingOrderRepository pendingOrderRepository;

    public CreateOrderServiceImp(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(),
                request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }
}
