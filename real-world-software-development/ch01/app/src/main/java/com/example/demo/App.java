package com.example.demo;

import java.io.IOException;

public class App {

    private static final String RESOURCES = "/Users/jihwooon/Workspaces/spring-in-action/real-world-software-development/ch01/app/src/main/resources/file.csv";

    public static void main(final String[] args) throws IOException {
        BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();

        BankStatementParser bankStatementCSVParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(RESOURCES, bankStatementCSVParser);
    }
}
