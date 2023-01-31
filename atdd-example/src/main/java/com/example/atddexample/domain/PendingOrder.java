package com.example.atddexample.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private int quantity;

}
