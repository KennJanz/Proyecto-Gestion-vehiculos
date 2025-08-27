/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import java.time.LocalDate;
import persons.Person;

public class Employee extends Person {

    private String position;
    private double salary;

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    } 

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee(String id, String name, LocalDate birthDate, String phone, String email, String position, double salary) {
        super(id, name, birthDate, phone);
        setEmail(email);
        this.position = position;
        this.salary = salary; 
    }

    @Override
    public String toString() {
        return "Employee{ID='" + getId() + "', Name='" + getName() + "', Birth Date=" + getBirthDate() + ", Age=" + getAge() + ", Phone='" + getPhone() + "', Email='" + getEmail() + "', Position='" + position + "', Salary=" + salary + "}";
    }
}
