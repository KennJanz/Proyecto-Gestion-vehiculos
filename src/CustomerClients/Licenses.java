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
    NONE(false),
    B1(true),
    B2(true);
    
    
    private final boolean Licenses; 

    private Licenses(boolean Licenses) {
        this.Licenses = Licenses;
    }

    public boolean isActiveLicenses() {
        return Licenses;
    }
        
}
