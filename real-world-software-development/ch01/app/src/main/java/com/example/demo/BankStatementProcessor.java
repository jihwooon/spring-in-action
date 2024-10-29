package com.example.demo;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        return summarizeTransactions(
                (acc, bankTransaction) -> bankTransaction.amount()
                        + acc);
    }

    public double calculateTotalAmountInMonth(Month month) {
        return summarizeTransactions(
                ((accumulator, bankTransaction) ->
                        bankTransaction.date().getMonth()
                                == month ? accumulator
                                + bankTransaction.amount() : accumulator
                ));
    }

    public double calculateTotalAmountByDescription(String description) {
        return summarizeTransactions(
                (accumulator, bankTransaction) ->
                        bankTransaction.description().equals(description) ?
                                accumulator
                                        + bankTransaction.amount() : accumulator
        );
    }

    public List<BankTransaction> findTransactionInMonthAndGreaterThanEqual(
            Month month, int amount) {
        return findTransactions(
                bankTransaction ->
                        bankTransaction.date().getMonth() == month
                                && bankTransaction.amount() >= amount);
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(
            final int amount) {
        return findTransactions(
                bankTransaction -> bankTransaction.amount() >= amount
        );
    }

    public List<BankTransaction> findTransactionsInMonthEqual(
            final Month month) {
        return findTransactions(
                bankTransaction ->
                        bankTransaction.date().getMonth()
                                == month);
    }

    public double maxTransactionsInMonth(Month month) {
        return maxTransactions(((accumulator, bankTransaction) ->
                bankTransaction.date().getMonth() == month
                        ? Math.max(accumulator,
                        bankTransaction.amount()) : accumulator));
    }

    public double minTransactionsInMonth(Month month) {
        return minTransactions(
                (accumulator, bankTransaction) ->
                        bankTransaction.date().getMonth() == month
                                ? Math.min(accumulator,
                                bankTransaction.amount()) : accumulator);
    }

    public double summarizeTransactions(
            final BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactions.stream()
                .reduce(0.0,
                        bankTransactionSummarizer::summarize,
                        Double::sum
                );
    }

    public List<BankTransaction> findTransactions(
            final BankTransactionFilter bankTransactionFilter) {
        return bankTransactions.stream()
                .filter(bankTransactionFilter::test)
                .toList();
    }

    public double maxTransactions(
            final BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactions.stream()
                .reduce(0.0,
                        bankTransactionSummarizer::summarize,
                        Double::max
                );
    }

    public double minTransactions(
            final BankTransactionSummarizer bankTransactionSummarizer) {
        return bankTransactions.stream()
                .reduce(0.0,
                        bankTransactionSummarizer::summarize,
                        Double::min
                );
    }
}
