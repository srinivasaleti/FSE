package com.fse;

public class FlightSearchEngine {
    private final Console console;
    private final FSERepository fseRepository;

    public FlightSearchEngine(Console console, FSERepository fseRepository) {
        this.console = console;
        this.fseRepository = fseRepository;
    }

    void search() {
        String options = "";
        while (true) {
            searchMenu();
            options = this.console.readString("Enter your options").toUpperCase();
            if (options.equals("A")) {
                String name = this.console.readString("Enter flight name");
                String result = SqlStatementSyntaxGenerator.searchByName(name);
                fseRepository.queryFlights(result).stream().forEach(x -> System.out.println(x));
            } else if (options.equals("B")) {
                String airlinesName = console.readString("Enter Airlines airlinesName");
                String result = SqlStatementSyntaxGenerator.searchByAirlines(airlinesName);
                fseRepository.queryFlights(result).stream().forEach(x -> System.out.println(x));
            } else if (options.equals("C")) {
                double minAmount = console.readDouble("Enter min amount");
                double maxAmount = console.readDouble("Enter max amount");
                String result = SqlStatementSyntaxGenerator.searchByPriceRange(minAmount, maxAmount);
                fseRepository.queryFlights(result).stream().forEach(x -> System.out.println(x));
            } else if (options.equals("D")) {
                int noOfStops = console.readInt("Enter no of stops you want");
                String result = SqlStatementSyntaxGenerator.searchByNoOfStops(noOfStops);
                fseRepository.queryFlights(result).stream().forEach(x -> System.out.println(x));
            } else if (options.equals("Q")) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    private void searchMenu() {
        System.out.println();
        System.out.println("Menu");
        System.out.println("=================================");
        System.out.println("A -> Search By Name");
        System.out.println("B-> Search By Airlines");
        System.out.println("C -> Search By Price Range");
        System.out.println("D -> Search By No of stops");
        System.out.println("Q -> Quit the application");
        System.out.println();
    }
}
