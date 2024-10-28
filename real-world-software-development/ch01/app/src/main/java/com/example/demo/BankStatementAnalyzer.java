package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    public void analyze(final String fileResource,
            final BankStatementParser bankStatementParser)
            throws IOException {

        final Path path = Paths.get(fileResource);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementParser.parserLinesFrom(
                lines);

        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(
                bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(
            BankStatementProcessor bankStatementProcessor) {

        System.out.println(
                "total : " + bankStatementProcessor.summarizeTransactions(
                        (acc, bankTransaction) -> bankTransaction.amount()
                                + acc)
        );

        System.out.println(
                "total for transactions in February is "
                        + bankStatementProcessor.summarizeTransactions(
                        ((accumulator, bankTransaction) ->
                                bankTransaction.date().getMonth()
                                        == Month.FEBRUARY ? accumulator
                                        + bankTransaction.amount() : accumulator
                        )));

        System.out.println("The total salary received is "
                + bankStatementProcessor.summarizeTransactions(
                ((accumulator, bankTransaction) ->
                        bankTransaction.description().equals("Salary") ?
                                accumulator
                                        + bankTransaction.amount() : accumulator
                ))
        );

        System.out.println("max for transactions in February is "
                + bankStatementProcessor.maxTransactions(
                ((accumulator, bankTransaction) ->
                        bankTransaction.date().getMonth() == Month.FEBRUARY
                                ? Math.max(accumulator,
                                bankTransaction.amount()) : accumulator)));

        System.out.println("min for transactions in February is "
                + bankStatementProcessor.minTransactions(
                (accumulator, bankTransaction) ->
                        bankTransaction.date().getMonth() == Month.FEBRUARY
                                ? Math.min(accumulator,
                                bankTransaction.amount()) : accumulator));

        System.out.println(
                "Find and print transactions that occurred in February "
                        + bankStatementProcessor.findTransactions(
                        new BankTransactionIsInFebruaryAndExpensive()));

        System.out.println("transactions that are in February and expensive "
                + bankStatementProcessor.findTransactions(
                bankTransaction ->
                        bankTransaction.date().getMonth() == Month.FEBRUARY
                                && bankTransaction.amount() >= 1000));

        System.out.println(
                "Find and print transactions with an amount equal to "
                        + bankStatementProcessor.findTransactions(
                        bankTransaction -> bankTransaction.amount() >= 1000
                ));

        System.out.println(
                "Find and print transactions that occurred in February "
                        + bankStatementProcessor.findTransactions(
                        bankTransaction ->
                                bankTransaction.date().getMonth()
                                        == Month.FEBRUARY)
        );
    }
}
