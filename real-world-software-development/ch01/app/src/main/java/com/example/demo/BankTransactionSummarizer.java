package com.example.demo;

@FunctionalInterface
public interface BankTransactionSummarizer {

    double summarize(double accumulator, BankTransaction bankTransaction);
}
