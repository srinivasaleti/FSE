package com.fse;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    static List<Flight> readFlightsFromCsv(String csvPath) {
        File file = new File(csvPath);
        List<Flight> flights = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(file.toPath(),
                    StandardCharsets.UTF_8);
            for (int i = 1; i < lines.size(); i++) {
                String[] array = lines.get(i).split(",", -1);
                Flight flight = new Flight(array[0], array[1], Double.parseDouble(array[2]), Integer.parseInt(array[3]));
                flights.add(flight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }
}
