/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persons;

import Utils.UtilDate;
import java.time.LocalDate;

/**
 *
 * @author unknown
 */
public abstract class Person {
    private String id;
    private LocalDate birthDate;
    private String email;
    private String phone; 
    private String name;

    public String getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
    
     public int getAge(){
        return UtilDate.calculateAge(birthDate);
    }

    public void setEmail(String email) {
        if (validateEmail(email))
        this.email = email;
    }

    public void setPhone(String phone) {
        if (validatePhone(phone))
            this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    private static boolean validateEmail(String email){
        return email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
    }
    
    private static boolean validatePhone(String phone){
        return phone.matches("^[0-9]{2}-[0-9]{2}-[0-9]{2}-[0-9]{2}$");
    }
    
    public Person(String id, String name, LocalDate birthDate, String phone) {
        this.id = id;
        this.name = name;
        if (UtilDate.isNotFutureDate(birthDate) && UtilDate.isLegalAge(birthDate)) {
        this.birthDate = birthDate;
        }
        if(validatePhone(phone))
            this.phone = phone;
    }
    
}
