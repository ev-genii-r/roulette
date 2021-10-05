package com.topolia.roulette;

import com.topolia.roulette.beans.UserDatabaseData;
import com.topolia.roulette.dao.DatabaseConnector;
import org.junit.jupiter.api.Test;

public class ApplicationTest {
    @Test
    public void anyTest(){
        DatabaseConnector databaseConnector = new DatabaseConnector();
        UserDatabaseData user = new UserDatabaseData(5, "Bobby", "topo", null);
        databaseConnector.addUser(user);
    }
}
