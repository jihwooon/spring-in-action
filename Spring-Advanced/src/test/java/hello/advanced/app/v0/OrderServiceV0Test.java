package hello.advanced.app.v0;

import org.junit.jupiter.api.Test;

class OrderServiceV0Test {
    private OrderRepositoryV0 orderRepository = new OrderRepositoryV0();
    private OrderServiceV0 orderServiceV0 = new OrderServiceV0(orderRepository);

    @Test
    void orderService() {
        String itemId = "ex1";
        orderServiceV0.orderItem(itemId);

        System.out.println(orderServiceV0);
    }
}
