package com.example.propertyapp;

public class Item {

    String address;
    String suburb;



    String state;
    String postcode;

    String price;


    public Item(String address, String suburb,String state, String postcode, String price) {
        this.address = address;
        this.suburb = suburb;
        this.postcode = postcode;
        this.price = price;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }




}
