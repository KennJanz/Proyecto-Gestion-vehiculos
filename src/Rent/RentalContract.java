/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Rent;

import CustomerClients.Clients;
import Cars.Car;
import java.time.LocalDate;

/**
 *
 * @author UTN
 */
public class RentalContract {

    private String contractId;
    private Clients client;
    private Car vehicle;
    private LocalDate startDate;
    private LocalDate endDate;
    private double amount;
    private String status;

    public String getContractId() {
        return contractId;
    }

    public Clients getClient() {
        return client;
    }

    public Car getVehicle() {
        return vehicle;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RentalContract() {
    }

    public RentalContract(String contractId, Clients client, Car vehicle,
            LocalDate startDate, LocalDate endDate, double amount,
            String status) {
        this.contractId = contractId;
        this.client = client;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.status = status;
    }

    @Override
    public String toString() {
        return contractId + " | " + client + " | " + vehicle + " | " + startDate + " | " + endDate + " | " + amount + " | " + status;
    }
}
