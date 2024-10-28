package com.example.demo;

import java.time.LocalDate;

public record BankTransaction(
        LocalDate date,
        double amount,
        String description) {

}
