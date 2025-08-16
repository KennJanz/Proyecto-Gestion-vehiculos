/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employee;

import Lists.List;
import java.util.ArrayList;
import java.util.HashSet;

public class EmployeeManager implements List<Employee> {

    private ArrayList<Employee> list;

    public EmployeeManager() {
        this.list = new ArrayList<>();
    }

    @Override
    public boolean add(Employee e) {
        if (find(e.getId()) != null) {
            return false;
        }
        // Validar edad mínima
        if (e.getAge() < 18) {
            return false;
        }
        list.add(e);
        return true;
    }

    public boolean removeById(String id) {
        Employee e = find(id);
        if (e != null) {
            list.remove(e);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Employee e) {
        return removeById(e.getId());
    }

    @Override
    public Employee find(Object id) {
        String strId = String.valueOf(id);
        for (Employee emp : list) {
            if (emp.getId().equals(strId)) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public void showAll() {

    }

    public HashSet<String> getPositions() {
        HashSet<String> positions = new HashSet<>();
        for (Employee emp : list) {
            positions.add(emp.getPosition());
        }
        return positions;
    }

    public ArrayList<Employee> getAllEmployees() {
        return list;
    }
} 
