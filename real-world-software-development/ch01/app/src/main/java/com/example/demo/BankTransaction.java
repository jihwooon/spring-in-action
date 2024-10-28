package com.example.demo;

import java.time.LocalDate;
import java.util.Objects;

public record BankTransaction(
        LocalDate date,
        double amount,
        String description) {

    public BankTransaction {
        Objects.requireNonNull(date);
        Objects.requireNonNull(amount);
        Objects.requireNonNull(description);
    }
}
