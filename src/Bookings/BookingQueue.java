/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bookings;

import Cars.CarType;
import Lists.List;
import exceptions.Bookings.BookingAlreadyStartedException;
import exceptions.Bookings.BookingNotFoundException;
import exceptions.Bookings.CarNotAvailableException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author unknown
 */
public class BookingQueue implements List<Booking>{
    Queue<Booking> queue;

    public BookingQueue() {
        this.queue = new LinkedList<>();
    }

    public Queue<Booking> getQueue() {
        return queue;
    }
    
    public boolean correctAdd(Booking b) throws CarNotAvailableException {
    for (Booking existing : queue) {
        boolean sameCar = existing.getCar().getLicensePlate().equals(b.getCar().getLicensePlate());
        boolean overlap = !(b.getEndDate().isBefore(existing.getStartDate()) || 
                            b.getStartDate().isAfter(existing.getEndDate()));
        if (sameCar && overlap && existing.getBookingState() == BookingState.CONFIRMED) {
            throw new CarNotAvailableException("El vehículo ya está reservado en ese rango de fechas.");
        }
    }
    return queue.offer(b);
}

    
    

   public boolean correctRemove(Booking b) 
        throws BookingNotFoundException, BookingAlreadyStartedException {
    if (!queue.contains(b)) {
        throw new BookingNotFoundException("La reserva con id " + b.getIdBooking() + " no existe.");
    }
    if (b.getStartDate().isBefore(java.time.LocalDate.now())) {
        throw new BookingAlreadyStartedException("No se puede cancelar, la reserva ya comenzó.");
    }
    return queue.remove(b);
}


    @Override
    public Booking find(Object id) {
    for (Booking booking : queue) {
        if (booking.getIdBooking().equals(id)) {
            return booking;
        }
    }
    return null;
    }

    @Override
    public void showAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public HashSet<BookingState> getBookingState(){
       HashSet<BookingState> set = new HashSet<>();
    for (Booking booking : queue) { 
        set.add(booking.getBookingState());
    }
    return set;
    }

    @Override
    public boolean add(Booking l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Booking l) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    
}
