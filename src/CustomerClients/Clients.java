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
    private final List<Booking> reservations;

    public Licenses getTypeLicenses() {
        return typeLicenses;
    }

    public String getLicense() {
        return license;
    }

    public void setTypeLicenses(Licenses typeLicenses) {
        this.typeLicenses = typeLicenses;
    }

    public void setLicense(String license) throws NoLicensesException {
        validateLicense(license);
        this.license = license;
    }

    private void validateLicense(String license) throws NoLicensesException {
        if (license == null || license.isBlank()) {
            throw new NoLicensesException();
        }
    }

    public boolean hasActiveReservation() {
        for (Booking r : reservations) {
            if (r != null && r.isActive()) {
                return true;
            }
        }
        return false;
    }

    public void addReservation(Booking b) {
        if (b != null) reservations.add(b);
    }

    public void removeReservation(Booking b) {
        reservations.remove(b);
    }

    public List<Booking> getReservations() {
        return reservations;
    }

    // ======= Constructores =======
    public Clients(String license, String id, String name, LocalDate birthDate, String phone, String email)
            throws NoLicensesException, PersonException {
        super(id, name, birthDate, phone, email);
        this.typeLicenses = Licenses.NONE;
        setLicense(license);
        this.reservations = new ArrayList<>();
    }

    public Clients(Licenses typeLicenses, String license, String id, String name, LocalDate birthDate, String phone, String email) throws PersonException,NoLicensesException {
        super(id, name, birthDate, phone, email);
        this.typeLicenses = typeLicenses;
        this.license = license;
        this.reservations = new ArrayList<>();
    }
    
    
}
