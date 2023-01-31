package hello.advanced.app.v0;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceV0 {
    private final OrderRepositoryV0 orderRepositoryV0;

    public OrderServiceV0(final OrderRepositoryV0 orderRepositoryV0) {
        this.orderRepositoryV0 = orderRepositoryV0;
    }

    public void orderItem(String itemId) {
        orderRepositoryV0.save(itemId);
    }
}
