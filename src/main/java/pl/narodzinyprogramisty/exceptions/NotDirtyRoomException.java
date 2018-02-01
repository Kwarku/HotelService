package pl.narodzinyprogramisty.exceptions;

public class NotDirtyRoomException extends Exception {
    public NotDirtyRoomException(){}


    @Override
    public String toString() {
        return "This room is not dirty, we cant clean this room";
    }
}
