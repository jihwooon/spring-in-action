package com.example.atddexample.application;

import com.example.atddexample.domain.PendingOrder;
import com.example.atddexample.domain.PendingOrderRepository;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

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
        private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

        @Override
        public PendingOrder createPendingOrder(final PendingOrderRequest request) {
            PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
            return pendingOrderRepository.save(pendingOrder);
        }
    }

}
