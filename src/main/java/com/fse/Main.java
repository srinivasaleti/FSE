package com.fse;

import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws SQLException {
        String host = args[0];
        String db = args[1];
        String userName = args[2];
        String password = args[3];
        String dbUrl = "jdbc:postgresql://" + host + "/" + db;

        Connection c = DbConfig.getDbConnection(dbUrl, userName, password);
        Scanner scanner = new Scanner(System.in);
        Console console = new Console(scanner);

        FSERepository fseRepository = new FSERepository(c);
        init(fseRepository);

        FlightSearchEngine flightSearchEngine = new FlightSearchEngine(console, fseRepository);
        flightSearchEngine.search();

        System.out.println("Thank You..");
        c.close();
    }

    private static void init(FSERepository fseRepository) {
        fseRepository.createFlightTable();
        System.out.println("Inserting flight records");
        String csvPath = Paths.get("src/main/java/com/fse/flights.csv").toAbsolutePath().toString();
        CsvReader.readFlightsFromCsv(csvPath).forEach(flight -> fseRepository.insertFlight(flight));
        System.out.println("Flight Records Inserted");
    }

}
