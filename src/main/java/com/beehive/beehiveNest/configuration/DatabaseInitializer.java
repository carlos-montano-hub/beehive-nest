package com.beehive.beehiveNest.configuration;

import java.sql.*;

public class DatabaseInitializer {

    //TODO get from env variables
    //The databases are not case sensitive
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres"; // connect to the default postgres db
    private static final String USER = "postgres";
    private static final String PASSWORD = "12345";
    private static final String DB_NAME = "beehive_nest";


    public static void createDatabaseIfNotExists() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {
            // Check if the database exists
            ResultSet result = statement.executeQuery("SELECT 1 FROM pg_database WHERE datname='" + DB_NAME + "';");
            if (!result.next()) {
                // If it doesn't exist, create it
                statement.executeUpdate("CREATE DATABASE " + DB_NAME);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

