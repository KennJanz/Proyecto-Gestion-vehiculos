/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions.Cars;

/**
 *
 * @author unknown
 */
public class DuplicateLicensePlateException extends Exception {

    public DuplicateLicensePlateException(String plate) {
        super("Similar car plate " + plate + " already exist!!");
    }
    
}
