package com.example.atddexample.api;

import com.example.atddexample.application.CreateOrderService;
import com.example.atddexample.application.PendingOrderRequest;
import com.example.atddexample.application.PendingOrderResponse;
import com.example.atddexample.domain.PendingOrder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApiController {
    private final CreateOrderService createOrderService;

    public OrderApiController(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/orders/pendingOrder")
    @ResponseStatus(HttpStatus.OK)
    public PendingOrderResponse createPendingOrder(@RequestBody PendingOrderRequest request) {
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        PendingOrderResponse response = new PendingOrderResponse(pendingOrder);
        return response;
    }
}
