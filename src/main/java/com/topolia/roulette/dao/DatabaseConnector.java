package com.topolia.roulette.dao;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.service.database.DatabaseAnaliser;

import java.sql.*;

public class DatabaseConnector implements DatabaseConnection{

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
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Users WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            user = new UserDatabaseData();
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setImage(resultSet.getString("image"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public Integer getIdByLogin(String login){
        try{
            PreparedStatement statement =
                    connection.prepareStatement("SELECT id FROM users WHERE login=?");
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt("id");
        } catch (SQLException e){
            return null;
        }
    }

    public void addUser(UserDatabaseData user){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Users (login, password, image) VALUES(?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getImage());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserDoesNotExists(String login){
        boolean result = true;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Users WHERE login=?");
            preparedStatement.setString(1,login);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if (resultSet.getString("login") != null) {
                result = false;
            }
        }catch (SQLException e){

        }
        return result;
    }

    public boolean isUserExists(String login, String password){
        boolean result = false;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Users WHERE login=? AND password=?");
            preparedStatement.setString(1,login);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            if (resultSet.getString("login") != null) {
                result = true;
            }
        }catch (SQLException e){

        }
        return result;
    }

    public void changeLogin(int id, String login){
        if(login == null){
            return;
        }
        if(login.length()<4){
            return;
        }
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update users set login = ? where id = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }catch (SQLException ex){

        }
    }

    public void changePicture(int id, String picture){
        System.out.println(id);
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update users set image = ? where id = ?");
            preparedStatement.setString(1, picture);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }catch (SQLException ex){

        }
    }

    public void changeBalance(int id, int balance){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update wallet set balance = balance + ? where id = ?");
            preparedStatement.setInt(1, balance);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }catch (SQLException ex){

        }
    }

    public void changePassword(int id, String password, String newPassword){
        System.out.println(id);
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update users set password = ? where id = ? and password = ?");
            preparedStatement.setString(1, newPassword);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }catch (SQLException ex){

        }
    }

    public boolean isWalletExists(String bill_number, String password){
        boolean result = false;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * from wallet where bill_number=? and password=?");
            preparedStatement.setString(1, bill_number);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            if(resultSet.getString("bill_number") != null){
                result = true;
            }
        }catch (SQLException e){

        }
        return result;
    }

    public int getWallet(String bill_number, String password){
        int id = 0;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT id from wallet where bill_number=? and password=?");
            preparedStatement.setString(1, bill_number);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            id = resultSet.getInt("id");
        }catch (SQLException e){

        }
        return id;
    }

    public int getWallet(int id){
        int balance = 0;
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT balance from wallet where id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            balance = resultSet.getInt("balance");
        }catch (SQLException e){

        }
        return balance;
    }
    public void changeMoney(int money, int id){
        try{
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE wallet set balance = balance + ? where id = ?");
            preparedStatement.setInt(1, money);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
        }catch (SQLException e){

        }
    }
}
