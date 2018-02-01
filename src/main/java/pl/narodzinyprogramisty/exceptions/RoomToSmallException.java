package pl.narodzinyprogramisty.exceptions;

public class RoomToSmallException extends Exception {
    public RoomToSmallException(){}

    @Override
    public String toString() {
        return "This room is too small";
    }
}
