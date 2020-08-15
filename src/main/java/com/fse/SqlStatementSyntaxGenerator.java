package com.fse;

public class SqlStatementSyntaxGenerator {
    public static String createFlightTableSyntax() {
        return "CREATE TABLE Flight " +
                "(ID SERIAL PRIMARY KEY     NOT NULL," +
                " NAME           TEXT    NOT NULL, " +
                " Airlines           TEXT    NOT NULL, " +
                " Price          float     NOT NULL, " +
                " No_Of_Stops      int)";
    }

    public static String insertFlightDetails(Flight flight) {
        return "INSERT INTO flight( name, airlines, price, no_of_stops) VALUES (" +
                " '" + flight.getName() + "',"
                + "'" + flight.getAirlines() + "', "
                + flight.getPrice() + ","
                + flight.getNoOfStops()
                + ")";
    }

    public static String searchByName(String value) {
        return "select * from flight where name = '" + value.toUpperCase() + "';";
    }

    public static String searchByAirlines(String value) {
        return "select * from flight where airlines = '" + value.toUpperCase() + "';";
    }

    public static String searchByPriceRange(double start, double end) {
        return "select * from flight where price between " + start + " and " + end + ";";
    }

    public static String searchByNoOfStops(int noOfStops) {
        return "select * from flight where no_of_stops = " + noOfStops + ";";
    }
}
