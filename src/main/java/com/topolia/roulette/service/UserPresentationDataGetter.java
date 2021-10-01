package com.topolia.roulette.service;

import com.topolia.roulette.beans.UserPresentationData;

/**
 * logic class to get presentation data from dao layer
 * @author Evgenii Rudkovskii 
 * @version 1.0(test)
 * @// TODO: 01.10.2021 access from dao layer
 * @// TODO: 01.10.2021 delete "testPossibility" method
 */
public class UserPresentationDataGetter {
    public UserPresentationData testPossibility(int id){
        String output = "error";
        switch (id){
            case 1: output = "bob";
            case 2: output = "bill";
            case 3: output = "joe";
        }
        UserPresentationData user = new UserPresentationData();
        user.setId(id);
        user.setName(output);
        return user;
    }
}
