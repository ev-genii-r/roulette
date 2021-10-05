package com.topolia.roulette.service.database;

import com.topolia.roulette.beans.UserDatabaseData;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseAnaliser {

    public static UserDatabaseData findUserById(ResultSet resultSet, int id){
        UserDatabaseData user = null;
        try {
            while (resultSet.next()) {
                if(resultSet.getInt("id") == id){
                    user = new UserDatabaseData(id,
                            resultSet.getString("login"),
                            resultSet.getString("password"),
                            resultSet.getString("image"));
                }
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        return user;
    }

    public static boolean isUserExist(ResultSet resultSet, String login, String password){
        boolean result = false;
        try {
            while (resultSet.next()) {
                if(resultSet.getString("login") == login &&
                        resultSet.getString("password") == password){
                    result = true;
                }
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        return result;
    }

    public static boolean isUserExist(ResultSet resultSet, String login){
        boolean result = false;
        try {
            while (resultSet.next()) {
                if(resultSet.getString("login") == login){
                    result = true;
                }
            }
        }catch (SQLException ex){
            ex.getMessage();
        }
        return result;
    }
}
