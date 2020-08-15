package com.fse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FSERepository {
    private final Connection connection;

    public FSERepository(Connection connection) {
        this.connection = connection;
    }

    void createFlightTable() {
        try {
            System.out.println("Creating Flight table");
            Statement stmt = this.connection.createStatement();
            String flightTableSyntax = SqlStatementSyntaxGenerator.createFlightTableSyntax();
            stmt.executeUpdate(flightTableSyntax);
            stmt.close();
            System.out.println("Flight Table Table Created");
        } catch (SQLException throwables) {
            System.out.println(throwables);
            System.out.println("Flight Table Table Creation failed");
        }
    }

    void insertFlight(Flight flight) {
        String insertFlightDetails = SqlStatementSyntaxGenerator.insertFlightDetails(flight);
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(insertFlightDetails);
            statement.close();
            System.out.println("Inserted flight : " + flight);
        } catch (SQLException throwables) {
            System.out.println(throwables);
            System.out.println("Failed to insert flight");
        }
    }

    List<Flight> queryFlights(String query) {
        Statement statement = null;
        List<Flight> flights = new ArrayList<>();
        try {
            System.out.println("Executing query : " + query);
            statement = this.connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            int c = 0;
            while (rs.next()) {
                Flight flight = new Flight(rs.getString("name"), rs.getString("airlines"), rs.getDouble("price"), rs.getInt("no_of_stops"));
                flights.add(flight);
                c += 1;
            }
            rs.close();
            System.out.println("No of rows found: " + c);
            statement.close();

        } catch (SQLException throwables) {
            System.out.println(throwables);
        }
        return flights;
    }
}
