package com.topolia.roulette.beans;

import java.util.Objects;

/**
 * bean with users presentation data
 * @author Evgenii Rudkovskii
 * @version 1.0
 */
public class UserPresentationData {
    
    private int id;
    private String name;

    private String picture;//include only URL

    public UserPresentationData(){

    }

    public UserPresentationData(int id, String name, String picture){
        this.id = id;
        this.name = name;
        this.picture = picture;
    }

    public UserPresentationData(UserPresentationData bean){
        this(bean.getId(), bean.getName(), bean.getPicture());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPicture() {
        return picture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPresentationData that = (UserPresentationData) o;
        return getId() == that.getId() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getPicture(), that.getPicture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPicture());
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( "class : " + getClass().getName() + " id : " + id + " name : " + name + " picture url : " + picture);
        return stringBuilder.toString();
    }
}
