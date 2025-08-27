/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Cars;

import exceptions.Cars.CarRentedException;
import exceptions.Cars.DuplicateLicensePlateException;
import java.time.Year;

/**
 *
 * @author unknown
 */
public class CarTest {
    public static void main(String[] args) throws CarRentedException {
           CarHashMap carManager = new CarHashMap();
    
        Car car1 = null;
Car car2 = null;

try {
   try {
     try{
         car1 = new Car("d-200", "seg", "koq", Year.of(1992), CarType.SEDAN,CarState.AVAILABLE);
         car1.setCarState(CarState.RENTED);
    carManager.CorrectAdd(car1);
//    carManager.correctRemove(car1);
    
    car1.toString();

    car2 = new Car("d-200e", "toyota", "corolla", Year.of(2026), CarType.SEDAN,CarState.AVAILABLE);
    car2.setCarState(CarState.RENTED);
    carManager.CorrectAdd(car2); 
//    carManager.correctRemove(car2);
    
    
       System.out.println(carManager.toString());
    
   }catch(CarRentedException e){
           System.out.println("Error: " + e.getMessage());
           }
   }catch(DuplicateLicensePlateException e){
       System.out.println("Error: " + e.getMessage() );
   }
} catch (IllegalArgumentException e){
    System.out.println("Error: " + e.getMessage());
}

// Uso después del try
//if (car1 != null) System.out.println(car1);
if (car2 != null) car1.setCarState(CarState.RENTED);
if (carManager != null) System.out.println(carManager.toString());


    }
}
