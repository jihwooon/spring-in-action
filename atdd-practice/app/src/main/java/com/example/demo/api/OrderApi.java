package com.example.demo.api;

import com.example.demo.application.CreateOrderService;
import com.example.demo.application.PendingOrderRequest;
import com.example.demo.application.PendingOrderResponse;
import com.example.demo.domain.PendingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderApi {

    private final CreateOrderService createOrderService;

    public OrderApi(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/pendingOrder")
    public ResponseEntity<PendingOrderResponse> createPendingOrder(@RequestBody
    PendingOrderRequest request) {
        PendingOrder pendingOrder = createOrderService.createPendingOrder(
                request);

        PendingOrderResponse response = new PendingOrderResponse(pendingOrder);

        return ResponseEntity.ok(response);
    }
}
