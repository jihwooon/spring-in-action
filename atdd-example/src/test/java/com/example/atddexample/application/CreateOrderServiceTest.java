package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CreateOrderServiceTest {

    private CreateOrderService createOrderService = new CreateOrderServiceImp();

    @Test
    void createPendingOrder() {
        long productId = 1L;
        int quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

    private static class CreateOrderServiceImp implements CreateOrderService {
        @Override
        public PendingOrder createPendingOrder(final PendingOrderRequest request) {
            throw new UnsupportedOperationException("CreateOrderServiceImp#createPendingOrder not implemented yet !!");
        }
    }
}
