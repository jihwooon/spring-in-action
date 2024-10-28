package com.example.demo;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parserFrom(String line);

    List<BankTransaction> parserLinesFrom(List<String> lines);
}
