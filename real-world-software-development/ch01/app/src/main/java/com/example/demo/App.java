package com.example.demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {

    private static final String RESOURCES = "/Users/jihwooon/Workspaces/spring-in-action/real-world-software-development/ch01/app/src/main/resources/file.csv";

    public static void main(final String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;

        for (final String line : lines) {
            final String[] columns = line.split(",");
            double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println(total);
    }
}
