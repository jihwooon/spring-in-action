package com.example.demo;

import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
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
                .filter(bankTransaction ->
                        bankTransactionFilter.test(bankTransaction))
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
