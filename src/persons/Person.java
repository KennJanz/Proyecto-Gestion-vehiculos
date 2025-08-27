package persons;

import Utils.UtilDate;
import exceptions.Person.PersonException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class Person {
    private static final Set<String> existingIds = new HashSet<>(); 
    
    private String id;
    private LocalDate birthDate;
    private String email;
    private String phone; 
    private String name;

    public String getId() {
        return id;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getAge() {
        return UtilDate.calculateAge(birthDate);
    }

    public void setEmail(String email) throws PersonException {
        if (!validateEmail(email)) {
            throw new PersonException("Invalid email format.");
        }
        this.email = email;
    }

    public void setPhone(String phone) throws PersonException {
        if (!validatePhone(phone)) {
            throw new PersonException("Phone must have 8 digits and contain only numbers.");
        }
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static boolean validateEmail(String email) {
        return email != null && 
               Pattern.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", email);
    }

    private static boolean validatePhone(String phone) {
        return phone != null && phone.matches("^[0-9]{8}$");
    }

    public Person(String id, String name, LocalDate birthDate, String phone, String email) throws PersonException {
        if (id == null || id.isBlank()) {
            throw new PersonException("ID cannot be empty.");
        }
        if (existingIds.contains(id)) {
            throw new PersonException("A person with this ID already exists.");
        }
        existingIds.add(id);
        this.id = id;

        if (name == null || name.isBlank()) {
            throw new PersonException("Name cannot be empty.");
        }
        this.name = name;

        if (!UtilDate.isNotFutureDate(birthDate)) {
            throw new PersonException("Birth date cannot be in the future.");
        }
        if (!UtilDate.isLegalAge(birthDate)) {
            throw new PersonException("Person must be at least 18 years old.");
        }
        this.birthDate = birthDate;

        if (!validatePhone(phone)) {
            throw new PersonException("Phone must have 8 digits and contain only numbers.");
        }
        this.phone = phone;

        if (!validateEmail(email)) {
            throw new PersonException("Invalid email format.");
        }
        this.email = email;
    }
}
