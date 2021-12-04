package com.topolia.roulette;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void anyTest(){
         DatabaseConnector databaseConnector = new DatabaseConnector();
        System.out.println(databaseConnector.getUser(5));
        System.out.println(databaseConnector.isUserDoesNotExists("jor"));
        System.out.println(databaseConnector.isUserExists("jora", "popa"));
        UserDatabaseData user = new UserDatabaseData( "pooooooo", "popopo", null);
        databaseConnector.addUser(user);
    }
}
