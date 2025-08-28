/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Rent;

/**
 *
 * @author Yumor
 */
public enum RentState {
    CANCEL("Cancel"),
    ACTIVE("Active"),
    FINALIZED("Finalized");
    
    private  String rentState;

    private RentState(String rentState) {
        this.rentState = rentState;
    }

    public String getRentState() {
        return rentState;
    }

    
    @Override
    public String toString() {
        return "RentState{" + "ordinal=" + ordinal() + ", name=" + name() + ", rentState=" + rentState + '}';
    }
    
    
}
