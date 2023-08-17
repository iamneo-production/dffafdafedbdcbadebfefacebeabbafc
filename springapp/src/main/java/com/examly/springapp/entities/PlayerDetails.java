package com.examly.springapp.entities;

import javax.persistence.*;


@Entity

public class PlayerDetails {

 

    @Id

    private int id;

 

    private String name;

    private int age;

    private String category;

    private double biddingPrice;

    private boolean sold;

    private String email;

 

   

    public PlayerDetails() {

    }

    public PlayerDetails(int id, String name, int age, String category, double biddingPrice, boolean sold,

            String email) {

        this.id = id;

        this.name = name;

        this.age = age;

        this.category = category;

        this.biddingPrice = biddingPrice;

        this.sold = sold;

        this.email = email;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBiddingPrice() {
        return biddingPrice;
    }

    public void setBiddingPrice(double biddingPrice) {
        this.biddingPrice = biddingPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

}

