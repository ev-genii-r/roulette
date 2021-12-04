package com.topolia.roulette.beans;

import java.util.Objects;

/**
 * include only database information about users
 * @author Evgenii Rudkovskii
 * @version 1.0
 */

public class UserDatabaseData {

    private int id;

    private String login;

    private String password;

    private String image;

    public UserDatabaseData(){

    }

    public UserDatabaseData(String login, String password, String image){
        this.password = password;
        this.login =  login;
        //this.id = id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDatabaseData that = (UserDatabaseData) o;
        return getId() == that.getId() &&
                Objects.equals(getLogin(), that.getLogin()) &&
                Objects.equals(getPassword(), that.getPassword()) &&
                Objects.equals(getImage(), that.getImage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLogin(), getPassword(), getImage());
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getName() + " id: " + id + " login: " + login + " password: " + password);
        return stringBuilder.toString();
    }
}
