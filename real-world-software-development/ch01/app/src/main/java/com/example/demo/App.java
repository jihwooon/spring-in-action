package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class App {

    private static final String RESOURCES = "/Users/jihwooon/Workspaces/spring-in-action/real-world-software-development/ch01/app/src/main/resources/file.csv";

    public static void main(final String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        List<BankTransaction> bankTransactions = bankStatementCSVParser.parserLinesFromCSV(
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
    }
}
