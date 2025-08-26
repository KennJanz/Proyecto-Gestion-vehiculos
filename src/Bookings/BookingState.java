/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Bookings;

/**
 *
 * @author unknown
 */
public enum BookingState {
    PENDING("Pending"),
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled");
    
    private String bookingState;

    public String getBookingState() {
        return bookingState;
    }

    private BookingState(String bookingState) {
        this.bookingState = bookingState;
    }

    @Override
    public String toString() {
        return "BookingState{" + "ordinal=" + ordinal() + ", name=" + name() + ", bookingState=" + bookingState + '}';
    }
    
    
}
