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
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);

        DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern(
                "dd-MM-yyyy");

        double total = lines.stream()
                .map(line -> line.split(","))
                .filter(columns ->
                        LocalDate.parse(columns[0], DATE_PATTERN).getMonth()
                                == Month.JANUARY)
                .mapToDouble(columns -> Double.parseDouble(columns[1]))
                .sum();

        System.out.println(total);
    }
}
