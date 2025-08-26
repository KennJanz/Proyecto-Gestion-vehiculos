package CustomerClients;

import Bookings.Booking;
import exceptions.Person.PersonException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import persons.Person;

public class Clients extends Person {
    private Licenses typeLicenses;
    private String license;
    private final List<Booking> reservations; // lista estándar

    public Licenses getTypeLicenses() { return typeLicenses; }
    public String getLicense() { return license; }
    public void setTypeLicenses(Licenses typelisenses) { this.typeLicenses = typelisenses; }

    public boolean hasActiveReservation() {
        for (Booking r : reservations) {
            if (r != null && r.isActive()) {
                return true;
            }
        }
        return false;
    }

    // utilidades opcionales
    public void addReservation(Booking b) { if (b != null) reservations.add(b); }
    public void removeReservation(Booking b) { reservations.remove(b); }
    public List<Booking> getReservations() { return reservations; }

    public Clients(String license, String id, String name, LocalDate birthDate, String phone, String email)
            throws NoLicensesException, PersonException {
        super(id, name, birthDate, phone, email);
        this.typeLicenses = Licenses.NONE;
        if (license == null || license.isBlank()) {
            throw new NoLicensesException();
        }
        this.license = license;
        this.reservations = new ArrayList<>(); // INICIALIZAR
    }
<<<<<<< Updated upstream
}
=======
    
    
   public void setLicense(String license) throws NoLicensesException {
        validateLicense(license);
        this.license = license;
    }
   
    private void validateLicense(String license) throws NoLicensesException {
        if (license == null || license.isBlank()) {
            throw new NoLicensesException();
        }
    }


   public Clients(String license, String id, String name, LocalDate birthDate, String phone) throws NoLicensesException {
    super(id, name, birthDate, phone);
    this.typeLicenses = Licenses.NONE;
    setLicense(license); 
}


}  

>>>>>>> Stashed changes
