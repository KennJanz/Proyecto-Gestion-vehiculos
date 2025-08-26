/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Cars;

/**
 *
 * @author unknown
 */
public enum CarType {
    SEDAN("Sedán"),
    SUV("SUV"),
    PICKUP("Pick-Up"),
    SUPERCAR("Super car");
    
    private String carTypes;

    public String getCarTypes() {
        return carTypes;
    }

    private CarType(String carTypes) {
        this.carTypes = carTypes;
    }
    
}
