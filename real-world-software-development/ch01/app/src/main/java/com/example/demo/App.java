package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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

        double total = bankStatementProcessor.calculateTotalAmount();

        System.out.println(total);
        List<BankTransaction> bankTransactionsInMonth = bankStatementProcessor.selectInMonth(
                bankTransactions, Month.JANUARY);

        System.out.println(bankTransactionsInMonth);
    }
}
