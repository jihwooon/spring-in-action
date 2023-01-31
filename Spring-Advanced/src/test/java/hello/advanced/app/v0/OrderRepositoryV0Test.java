package hello.advanced.app.v0;

import org.junit.jupiter.api.Test;

class OrderRepositoryV0Test {

    @Test
    void result() {
        String itemId = "3ex";
        OrderRepositoryV0 repository = new OrderRepositoryV0();

        repository.save(itemId);
        System.out.println("repository: " + repository);
    }
}
