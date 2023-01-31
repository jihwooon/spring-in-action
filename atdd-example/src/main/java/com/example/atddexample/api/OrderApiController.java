package com.example.atddexample.api;

import com.example.atddexample.application.PendingOrderRequest;
import com.example.atddexample.application.PendingOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApiController {
    @PostMapping("/orders/pendingOrder")
    @ResponseStatus(HttpStatus.OK)
    public PendingOrderResponse createPendingOrder(@RequestBody PendingOrderRequest request) {
        PendingOrderResponse response = new PendingOrderResponse(request.getProductId(), request.getQuantity());
        return response;
    }
}
