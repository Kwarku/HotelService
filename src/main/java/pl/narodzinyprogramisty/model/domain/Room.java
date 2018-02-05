package pl.narodzinyprogramisty.model.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Room {
    private int roomNumber;
    private int numberOfPeople;
    private boolean isBathroom;
    private boolean isAvailable;
    private boolean isClean;
    private List<Guest> guestList;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Room(int roomNumber, int numberOfPeople, boolean isBathroom) {
        this.roomNumber = roomNumber;
        this.numberOfPeople = numberOfPeople;
        this.isBathroom = isBathroom;
        this.isAvailable = true;
        this.isClean = true;
    }


    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(byte roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfPeople() {
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
        String show = String.format("Room nr: %-4d, for %-3d people, is bathroom in : %-6s. Will be free : %d %s %d. %nGuest list: %s",
                roomNumber,
                numberOfPeople,
                isBathroom,
                //blad
                checkOutDate.getDayOfMonth(),
                checkOutDate.getMonth(),
                checkOutDate.getYear(),
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber &&
                numberOfPeople == room.numberOfPeople &&
                isBathroom == room.isBathroom &&
                isAvailable == room.isAvailable &&
                isClean == room.isClean &&
                Objects.equals(guestList, room.guestList) &&
                Objects.equals(checkInDate, room.checkInDate) &&
                Objects.equals(checkOutDate, room.checkOutDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roomNumber, numberOfPeople, isBathroom, isAvailable, isClean, guestList, checkInDate, checkOutDate);
    }
}
