/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import Lists.List;
import employee.Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class EmployeeManager implements List<Employee> {

    private ArrayList<Employee> list;

    public EmployeeManager() {
        this.list = new ArrayList<>();
    }

    // Devuelve la lista completa
    public ArrayList<Employee> getList() {
        return list;
    }

    @Override
    public boolean add(Employee e) {
        if (find(e.getId()) != null) { // no duplicados por ID
            return false;
        }
        list.add(e);
        return true;
    }

    @Override
    public boolean remove(Employee e) {
        return list.remove(e); // elimina si existe
    }

    @Override
    public Employee find(Object id) {
        String strId = String.valueOf(id);
        for (Employee e : list) {
            if (e.getId().equals(strId)) {
                return e;
            } 
        }
        return null;
    }

    @Override
    public void showAll() {
        for (Employee e : list) {
            System.out.println(e);
        }
    }

    // Devuelve un conjunto de posiciones únicas
    public HashSet<String> getPositions() {
        HashSet<String> set = new HashSet<>();
        for (Employee e : list) {
            set.add(e.getPosition());
        }
        return set;
    }
}
