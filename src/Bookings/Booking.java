/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookings;

import Cars.Car;
import CustomerClients.Clients;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author unknown
 */
public class Booking {
    private String idBooking;
    private Clients client;
    private Car car;
    private LocalDate endDate;
    private LocalDate startDate;
    private BookingState bookingState;

    public String getIdBooking() {
        return idBooking;
    }

    public Clients getClient() {
        return client;
    }

    public Car getCar() {
        return car;
    }
    
    

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public BookingState getBookingState() {
        return bookingState;
    }

    public void setBookingState(BookingState bookingState) {
        this.bookingState = bookingState;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void setCar(Car car) {
        this.car = car;
    }
    
    
    
   public boolean isActive() {
    LocalDate today = LocalDate.now();
    
    return bookingState == BookingState.CONFIRMED &&
       ( (today.isEqual(startDate) || today.isAfter(startDate)) &&
         (today.isEqual(endDate)   || today.isBefore(endDate)) );

   }

   public long getDurationInDays() {
   return ChronoUnit.DAYS.between(startDate, endDate);
   }

   public boolean isWithinRange(LocalDate startDate, LocalDate endDate) {
     return ( !startDate.isAfter(endDate) && !endDate.isBefore(startDate) );
   }

   public Booking(String idBooking, Clients client, Car car, LocalDate startDate, LocalDate endDate, BookingState bookingState) {

    if (client == null) {
        throw new IllegalArgumentException("Client cannot be null.");
    }

    if (car == null) {
        throw new IllegalArgumentException("Car cannot be null.");
    }

    LocalDate today = LocalDate.now();

    if (startDate == null || endDate == null) {
        throw new IllegalArgumentException("Start and end dates cannot be null.");
    }

    if (startDate.isBefore(today)) {
        throw new IllegalArgumentException("Start date cannot be before today's date.");
    }

    if (endDate.isBefore(startDate)) {
        throw new IllegalArgumentException("End date must be after start date.");
    }

    long duration = ChronoUnit.DAYS.between(startDate, endDate);
    if (duration > 30) {
        throw new IllegalArgumentException("Booking duration cannot exceed 30 days.");
    }

    this.idBooking = idBooking;
    this.client = client;
    this.car = car;
    this.startDate = startDate;
    this.endDate = endDate;
    this.bookingState = bookingState;
}

   
   

}
