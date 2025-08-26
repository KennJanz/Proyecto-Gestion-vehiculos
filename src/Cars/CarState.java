/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Cars;

/**
 *
 * @author unknown
 */
public enum CarState {
    AVAILABLE("AVAILABLE"),
    MAINTENANCE("Maintenance"),
    RENTED("Rented");
    
    private String carStateEnum;

    public String getCarStateEnum() {
        return carStateEnum;
    }

    private CarState(String carStateEnum) {
        this.carStateEnum = carStateEnum;
    }
    
    
    
    
    
    
    
    
    
}
