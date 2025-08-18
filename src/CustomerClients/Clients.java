/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerClients;

import java.time.LocalDate;
import persons.Person;

/**
 *
 * @author Yumor
 */
public class Clients extends Person{
    private Licenses typeLicenses; 
    private String license; 

    public Licenses getTypeLicenses() {
        return typeLicenses;
    }

    public String getLicense() {
        return license;
    }

    public void setTypeLicenses(Licenses typelisenses) {
        this.typeLicenses = typelisenses;
    }

    public Clients(String lisence, String id, String name, LocalDate birthDate, String phone) throws  NoLicensesException {
    super(id, name, birthDate, phone);
    this.typeLicenses = Licenses.NONE;
    if (lisence == null || lisence.isBlank()) {
        throw new NoLicensesException();
    }
     this.license = lisence;
}

    
}
