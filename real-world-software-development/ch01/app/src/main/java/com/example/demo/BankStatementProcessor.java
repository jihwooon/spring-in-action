package com.example.demo;

import java.time.Month;
import java.util.List;

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
                .toList();
    }

    public double calculateTotalInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.date().getMonth()
                        == month)
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public double calculateTotalForCategory(final String category) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.description()
                        .equals(category))
                .mapToDouble(BankTransaction::amount)
                .sum();
    }

    public double calculateMaxInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.date().getMonth()
                        == month)
                .mapToDouble(BankTransaction::amount)
                .max()
                .orElse(0);
    }

    public double calculateMinInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.date().getMonth()
                        == month)
                .mapToDouble(BankTransaction::amount)
                .min()
                .orElse(0);
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(
            final int amount) {
        return bankTransactions.stream()
                .filter(bankTransaction -> bankTransaction.amount() >= amount)
                .toList();
    }

    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        return bankTransactions.stream()
                .filter(bankTransaction ->
                        bankTransaction.date().getMonth() == month)
                .toList();
    }


    public List<BankTransaction> findTransactionsInMonthAndGreater(
            final Month month,
            final int amount) {
        return bankTransactions.stream()
                .filter(bankTransaction ->
                        bankTransaction.date().getMonth() == month &&
                                bankTransaction.amount() >= amount
                )
                .toList();
    }
}
