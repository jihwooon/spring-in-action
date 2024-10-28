package com.example.demo;

import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public List<BankTransaction> selectInMonth(
            final List<BankTransaction> bankTransactions, final
    Month month) {

        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.date().getMonth()
                        == month)
                .collect(Collectors.toList());
    }
}
