package com.topolia.roulette.dao;

import com.topolia.roulette.beans.UserDatabaseData;

public interface DatabaseConnection {
    UserDatabaseData getUser(int id);

    Integer getIdByLogin(String login);

    void addUser(UserDatabaseData user);

    boolean isUserDoesNotExists(String login);

    boolean isUserExists(String login, String password);
}
