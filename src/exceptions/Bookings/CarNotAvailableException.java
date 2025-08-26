/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.Bookings;

/**
 *
 * @author unknown
 */
public class CarNotAvailableException extends Exception{
    public CarNotAvailableException(String message) {
        super("" + message); 
    }
}
