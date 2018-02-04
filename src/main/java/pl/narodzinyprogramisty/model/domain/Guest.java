package pl.narodzinyprogramisty.model.domain;

import java.time.LocalDate;

public class Guest {
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;

    public Guest(String name, String lastName, LocalDate dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("%s %s, ur.%d %s %d%n", name, lastName,dateOfBirth.getDayOfMonth(),dateOfBirth.getMonth() ,dateOfBirth.getYear());
    }
}
