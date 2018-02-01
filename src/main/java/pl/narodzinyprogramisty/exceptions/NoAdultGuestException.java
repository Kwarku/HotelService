package pl.narodzinyprogramisty.exceptions;

public class NoAdultGuestException extends Exception {
    public NoAdultGuestException(){}

    @Override
    public String toString() {

        return "Any adult in guest list";
    }
}
