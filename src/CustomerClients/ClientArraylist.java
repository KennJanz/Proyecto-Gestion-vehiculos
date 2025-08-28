/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CustomerClients;

import CustomerClients.Clients;
import Lists.List;
import employee.Employee;
import exceptions.Clients.ActiveReservationException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Yumor
 */
    public class ClientArraylist implements List<Clients> {

    private ArrayList<Clients> list;

    public ClientArraylist() {
        this.list = new ArrayList<>();
    }

    public ArrayList<Clients> getList() {
        return list;
    }
    

    @Override
    public boolean add(Clients e) {
        if (find(e.getId()) != null) {
            return false;
        }
        
        if (e.getAge() < 18) {
            return false;
        }
        list.add(e);
        return true;
        
        
    }

   public boolean removeById(String id) throws ActiveReservationException {
    Clients e = find(id);

    if (e != null) {
        if (e.hasActiveReservation()) {
            throw new ActiveReservationException(
                "No se puede eliminar el cliente con ID " + id + " porque tiene reservas activas."
            );
        }

        list.remove(e);
        return true;
    }
    return false;
}

   

    
    @Override
    public Clients find(Object id) {
        String strId = String.valueOf(id);
        for (Clients emp : list) {
            if (emp.getId().equals(strId)) {
                return emp;
            }
        }
        return null;
    }

    @Override
    public void showAll() {

    }

   public HashSet<Licenses> getPositions() {
    HashSet<Licenses> positions = new HashSet<>();
    for (Clients emp : list) {
        positions.add(emp.getTypeLicenses());
    }
    return positions;
}

    public ArrayList<Clients> getAllEmployees() {
        return list;
    }

    @Override
    public boolean remove(Clients l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

} 


