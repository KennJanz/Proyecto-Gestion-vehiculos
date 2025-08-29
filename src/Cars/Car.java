/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cars;

import java.time.Year;

/**
 *
 * @author unknown
 */
public class Car {
    private String licensePlate;
    private String brand;
    private String model;
    private Year year;
    private CarType carType;
    private CarState carState;
    
    public boolean isAvailable(){
        switch(carState){
            case AVAILABLE:
                return true;
            case MAINTENANCE:
                return false;
            case RENTED:
                return false;
                default:
                return false;
        }
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public CarType getCarType() {
        return carType;
    }

    public CarState getCarState() {
        return carState;
    }

    public void setCarState(CarState carState) {
        this.carState = carState;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }
    
    

    public Car(String licensePlate, String brand, String model, Year year, CarType carType, CarState carState) {

        int currentYear = Year.now().getValue();
        int carYear = year.getValue();

        
        if (carYear > currentYear) {
            throw new IllegalArgumentException("The year cannot be older than the current one.");
        }
        if (currentYear - carYear > 20) {
            throw new IllegalArgumentException("The car cannot be more than 20 years old.");
        }
        
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.model = model;
        this.year = year;
        this.carType = carType;
        this.carState = carState;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + licensePlate + ")";
    }

    
    
    
    
}