/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package CustomerClients;

/**
 *
 * @author Yumor
 */
public enum Licenses {
    B1(true),
    B2(true), 
    NONE(false); 
    
    private final boolean Licenses; 

    private Licenses(boolean Licenses) {
        this.Licenses = Licenses;
    }

    public boolean isLicenses() {
        return Licenses;
    }
        
}
