package com.topolia.roulette.service;

import com.topolia.roulette.exception.SignInException;

/**
 * compare users data with database
 *
 * @throws SignInException exception for controller
 * @see com.topolia.roulette.controllers.SignInController
 *
 * @author Evgenii Rudkovskii
 * @version 1.0
 * @// TODO: 02.10.2021 connect it with dao layer
 */
public class SignInCheck {
    public static boolean doesItExist(String login, String password) throws SignInException {
        return true;
    }
}
