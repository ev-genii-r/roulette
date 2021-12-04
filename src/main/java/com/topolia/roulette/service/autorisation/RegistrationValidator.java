package com.topolia.roulette.service.autorisation;

import com.topolia.roulette.controllers.autorisation.RegistrationController;
import com.topolia.roulette.dao.DatabaseConnector;
import com.topolia.roulette.exception.RegistrationException;

/**
 * check registration form
 *
 * @throws RegistrationException for controller
 * @see RegistrationController
 *
 * @author Evgenii Rudkovskii
 * @version 1.0
 *
 * @// TODO: 02.10.2021 compare with database
 */
public class RegistrationValidator {
    public static boolean registrationTest(String login,
                                           String password,
                                           String confirmPassword) throws RegistrationException {

        if(password == null || login == null || confirmPassword == null){
            throw new RegistrationException("Нужно заполнить все поля");
        }

        if(!password.equals(confirmPassword)){
            throw new RegistrationException("Пароли должны быть одинаковыми");
        }

        if(login.length() < 4 || password.length() < 4){
            throw new RegistrationException("Логин и пароль должны быть длиннее 4 символов");
        }
        DatabaseConnector databaseConnector = new DatabaseConnector();
        if(!databaseConnector.isUserDoesNotExists(login)){
            throw new RegistrationException("Пользователь с данным логином уже существует");
        }
        return true;
    }
}
