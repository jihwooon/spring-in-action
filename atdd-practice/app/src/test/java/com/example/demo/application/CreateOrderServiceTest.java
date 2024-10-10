package com.example.demo.application;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.demo.domain.PendingOrder;
import com.example.demo.repository.PendingOrderRepository;
import com.example.demo.repository.PendingOrderRepositoryMemoryImpl;
import org.junit.jupiter.api.Test;

public class CreateOrderServiceTest {

    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();
    private CreateOrderService createOrderService = new CreateOrderServiceImp(
            pendingOrderRepository);

    @Test
    void createPendingOrder() {
        long productId = 1L;
        int quantity = 2;

        PendingOrderRequest request = PendingOrderRequest.of(productId,
                quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(
                request);

        assertThat(pendingOrder.getId()).isPositive();
    }

}
