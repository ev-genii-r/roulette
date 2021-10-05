package com.topolia.roulette.dao;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.service.database.DatabaseAnaliser;

import java.sql.*;

public class DatabaseConnector {

    private static final String URL = "jdbc:postgresql://localhost:5432/roulette";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "frfeyncnbv";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserDatabaseData getUser(int id){
        UserDatabaseData user = null;
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(SQL);
            user = DatabaseAnaliser.findUserById(resultSet, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(UserDatabaseData user){
        String SQL = "INSERT INTO Users VALUES(" +
                user.getId() + ", '" +
                user.getLogin() + "', '" +
                user.getPassword() + "', '" +
                user.getImage() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
