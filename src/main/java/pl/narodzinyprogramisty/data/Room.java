package pl.narodzinyprogramisty.data;

import java.time.LocalDate;
import java.util.List;

public class Room {
    private byte roomNumber;
    private byte numberOfPeople;
    private boolean isBathroom;
    private boolean isAvailable;
    private boolean isClean;
    private List<Guest> guestList;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Room(byte roomNumber, byte numberOfPeople, boolean isBathroom) {
        this.roomNumber = roomNumber;
        this.numberOfPeople = numberOfPeople;
        this.isBathroom = isBathroom;
        this.isAvailable = true;
        this.isClean = true;
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

    public boolean isClean() {
        return isClean;
    }

    public void setClean(boolean clean) {
        isClean = clean;
    }

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    private List<Guest> showGuestList(){
        if (!isAvailable) {
            return guestList;
        }
        return null;
    }

    @Override
    public String toString() {
        if (!isAvailable){
             return showWhenRoomIsBookedNow();
        }else if (!isClean){
            return showWhenRoomIsDirty();
        }
        return showWhenRoomIsReadyToBooked();
    }

    private String showWhenRoomIsReadyToBooked(){
        String show = String.format("Room nr: %-4d, for %-3d people, is bathroom in : %-6s",
                roomNumber,
                numberOfPeople,
                isBathroom);
        return show;
    }

    private String showWhenRoomIsBookedNow(){
        String show = String.format("Room nr: %-4d, for %-3d people, is bathroom in : %-6s.%nGuest list: %s",
                roomNumber,
                numberOfPeople,
                isBathroom,
                showGuestList());
        return show;
    }
    private String showWhenRoomIsDirty(){
        String show = String.format("Room nr: %-4d, for %-3d people, is bathroom in : %-6s, Room dirty",
                roomNumber,
                numberOfPeople,
                isBathroom);
        return show;
    }
}
