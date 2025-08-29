package Cars;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import employee.Employee;
import exceptions.Cars.CarRentedException;
import exceptions.Cars.DuplicateLicensePlateException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author unknown
 */
public class CarHashMap implements Lists.List<Car>{
    HashMap<String,Car> map; 

    public CarHashMap() {
        this.map = new HashMap<>();
    }

    public HashMap<String, Car> getMap() {
        return map;
    }

    
    

    
    public boolean CorrectAdd(Car t) throws DuplicateLicensePlateException {
        if (map.containsKey(t.getLicensePlate())) {
            throw new DuplicateLicensePlateException(t.getLicensePlate());
        }
            map.put(t.getLicensePlate(), t);
            return true;
    }


    public boolean correctRemove(Car t) throws CarRentedException {
         if (!map.containsKey(t.getLicensePlate())) return false;
    Car car = map.get(t.getLicensePlate());

    if (car.getCarState() == CarState.RENTED) {
        throw new CarRentedException("The car with the license plate cannot be removed. " + t.getLicensePlate() + "because it is rented.");
    }

    map.remove(t.getLicensePlate());
    return true;
    }

    @Override
    public Car find(Object id) {
        String strId = String.valueOf(id);
        return map.get(strId);
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public HashSet<CarState> getCarStates(){
        HashSet<CarState> set = new HashSet<>();
        for (Car car:map.values()){
            set.add(car.getCarState());
        }
        return set;
    }
      
    public HashSet<CarType> getCarTypes(){
        HashSet<CarType> set = new HashSet<>();
        for (Car car:map.values()){
            set.add(car.getCarType());
        }
        return set;
    }

    @Override
    public boolean add(Car l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        return "CarHashMap{" + "map=" + map + '}';
    }

    @Override
    public boolean remove(Car l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Collection<Car> getAll() {
    return map.values();
}


    
} 
