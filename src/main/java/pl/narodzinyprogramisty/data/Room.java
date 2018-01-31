package pl.narodzinyprogramisty.data;

public class Room {
    private byte roomNumber;
    private byte numberOfPeople;
    private boolean isBathroom;
    private boolean isAvailable;

    public Room(byte roomNumber, byte numberOfPeople, boolean isBathroom) {
        this.roomNumber = roomNumber;
        this.numberOfPeople = numberOfPeople;
        this.isBathroom = isBathroom;
        this.isAvailable = true;
    }


    public byte getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(byte roomNumber) {
        this.roomNumber = roomNumber;
    }

    public byte getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(byte numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public boolean isBathroom() {
        return isBathroom;
    }

    public void setBathroom(boolean bathroom) {
        isBathroom = bathroom;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        String show = String.format("Room nr: %-4d, for %-3d people, is bathroom in : %-6s, is free: %-6s",
                roomNumber,
                numberOfPeople,
                isBathroom,
                isAvailable);
        return show;
    }
}
