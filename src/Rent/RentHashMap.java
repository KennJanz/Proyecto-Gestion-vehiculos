/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rent;

import Lists.List;
import CustomerClients.Clients;
import Cars.Car;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author UTN
 */
public class RentHashMap implements List<RentalContract> {

    private HashMap<String, RentalContract> map;

    // Referencias a clientes y vehículos registrados
    private HashMap<String, Clients> clientsMap;
    private HashMap<String, Car> carsMap;

    public RentHashMap(HashMap<String, Clients> clientsMap, HashMap<String, Car> carsMap) {
        this.map = new HashMap<>();
        this.clientsMap = clientsMap;
        this.carsMap = carsMap;
    }

    public HashMap<String, RentalContract> getMap() {
        return map;
    }

    public boolean addCorrect(Clients e)throws ClientNotFoundException, CarNotFoundException, InvalidDateException {

        // Validar contrato duplicado
        if (map.containsKey(e.getId())) {
            return false;
        }

        // Validar cliente registrado
        if (e.getId() == null || !clientsMap.containsKey(e.getId().getId())) {
            throw new ClientNotFoundException(
                    "La cédula " + (e.getClient() != null ? e.ggetId().getId() : "null")
                    + " no pertenece a un cliente registrado."
            );
        }

        // Validar vehículo registrado
        if (e.getVehicle() == null || !carsMap.containsKey(e.getVehicle().getLicensePlate())) {
            throw new CarNotFoundException(
                    "La placa " + (e.getVehicle() != null ? e.getVehicle().getLicensePlate() : "null")
                    + " no pertenece a un vehículo registrado."
            );
        }

        // Validar fecha de inicio
        if (e.getStartDate().isBefore(LocalDate.now())) {
            throw new InvalidDateException(
                    "La fecha de inicio " + e.getStartDate() + " no puede ser menor a la fecha actual."
            );
        }

        // Si todo es válido, se guarda el contrato
        map.put(e.getContractId(), e);
        return true;
    }

    public boolean removeById(String id) throws ActiveContractException {
        RentalContract e = map.get(id);

        if (e != null) {
            if ("Activo".equalsIgnoreCase(e.getStatus())) {
                throw new ActiveContractException(
                        "No se puede eliminar el contrato con ID " + id + " porque está ACTIVO."
                );
            }
            map.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public RentalContract find(Object id) {
        String strId = String.valueOf(id);
        return map.get(strId);
    }

    @Override
    public void showAll() {
        for (RentalContract contract : map.values()) {
            System.out.println(contract);
        }
    }

    public HashSet<String> getStatuses() {
        HashSet<String> statuses = new HashSet<>();
        for (RentalContract contract : map.values()) {
            statuses.add(contract.getStatus());
        }
        return statuses;
    }

    public Collection<RentalContract> getAllContracts() {
        return map.values();
    }

    @Override
    public boolean remove(RentalContract e) {
        if (e == null || e.getContractId() == null) {
            return false;
        }

        if ("Activo".equalsIgnoreCase(e.getStatus())) {
            System.err.println("❌ No se puede eliminar el contrato con ID "
                    + e.getContractId() + " porque está ACTIVO.");
            return false;
        }

        return map.remove(e.getContractId(), e);
    }

    @Override
    public boolean add(RentalContract l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
