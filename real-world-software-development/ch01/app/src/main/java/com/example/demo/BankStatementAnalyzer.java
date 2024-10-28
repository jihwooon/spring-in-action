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

        collectSummary(bankStatementProcessor, bankTransactions);
    }

    private static void collectSummary(
            BankStatementProcessor bankStatementProcessor,
            List<BankTransaction> bankTransactions) {

        System.out.println(
                "total : " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("total for transactions in January is "
                + bankStatementProcessor.selectInMonth(
                bankTransactions, Month.JANUARY));

        System.out.println(
                "total for transactions in February is "
                        + bankStatementProcessor.calculateTotalInMonth(
                        Month.FEBRUARY));

        System.out.println("The total salary received is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));

        System.out.println("max for transactions in February is "
                + bankStatementProcessor.calculateMaxInMonth(Month.FEBRUARY));

        System.out.println("min for transactions in February is "
                + bankStatementProcessor.calculateMinInMonth(
                Month.FEBRUARY));

        System.out.println(
                "Find and print transactions that occurred in February "
                        + bankStatementProcessor.findTransactions(
                        new BankTransactionIsInFebruaryAndExpensive()));

        System.out.println("transactions that are in February and expensive "
                + bankStatementProcessor.findTransactions(
                bankTransaction ->
                        bankTransaction.date().getMonth() == Month.FEBRUARY
                                && bankTransaction.amount() >= 1000));
    }
}
