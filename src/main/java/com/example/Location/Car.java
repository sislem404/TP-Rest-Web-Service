package com.example.Location;

public class Car {
private String plateNumber;
private String brand;
private int price;


    public Car(String plateNumber, String brand, int price) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
    }


    public String getPlateNumber() {
    return plateNumber;
}

public String getBrand() {
    return brand;
}

public int getPrice() {
    return price;
}

}

