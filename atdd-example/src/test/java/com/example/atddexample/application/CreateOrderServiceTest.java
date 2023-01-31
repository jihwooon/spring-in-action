package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;
import com.example.atddexample.domain.PendingOrderRepository;
import com.example.atddexample.infra.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CreateOrderServiceTest {
    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImp(pendingOrderRepository);

    @Test
    void createPendingOrder() {
        long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

}
