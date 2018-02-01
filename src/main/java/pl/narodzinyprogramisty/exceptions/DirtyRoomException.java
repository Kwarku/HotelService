package pl.narodzinyprogramisty.exceptions;

public class DirtyRoomException extends Exception {
    public DirtyRoomException(){}

    @Override
    public String toString() {
        return "This room is dirty, you cant book dirty room. Call cleaning service";
    }
}
