package pl.narodzinyprogramisty.model;

import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.CreateHotel;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements HotelServiceAPI {
    private static final int YEARS_TO_ADULTS = 18;

    private Hotel hotel;

    public HotelService(){
        this(CreateHotel.makeNewHotel());
    }

    public HotelService(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = createRoomsList();
        rooms.addAll(hotel.getRoomsInHotel());
        return rooms;
    }


    public List<Room> getAllAvailableRooms() {
        List<Room> availableRooms = createRoomsList();
        takeAvailableRoom(availableRooms);
        return availableRooms;
    }


    public boolean bookRoom(int roomNumber, List<Guest> guests, int numberOfNights) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        if (isReadyToOrder(getRoom(roomNumber), guests)) {
            setReservation(getRoom(roomNumber));
            accommodateGuests(getRoom(roomNumber), guests);
            setDateOfReleaseRoom(getRoom(roomNumber), numberOfNights);
            return true;
        }
        return false;
    }


    public boolean makeRoomEmpty(int roomNumber) {
        if (!isRoomFree(getRoom(roomNumber))) {
            releaseTheRoom(getRoom(roomNumber));
            return true;
        }
        return false;
    }

    public boolean makeRoomClean(int roomNumber) throws NotDirtyRoomException {
        if (isRoomDirty(getRoom(roomNumber))) {
            cleanRoom(getRoom(roomNumber));
            return true;
        }
        throw new NotDirtyRoomException();
    }

    private void setDateOfReleaseRoom(Room room, int numberOfNights) {
        setDateOfStartVisit(room);
        room.setCheckOutDate(room.getCheckInDate().plusDays(numberOfNights));

    }

    private void setDateOfStartVisit(Room room) {
        room.setCheckInDate(LocalDate.now());
    }

    private boolean isRoomDirty(Room room) {
        return !room.isClean();
    }

    private void cleanRoom(Room room) {
        room.setClean(true);
    }

    private boolean isReadyToOrder(Room room, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        return isRoomFree(room) && isAnyAdult(guests) && isSizeEnough(room, guests) && isRoomClean(room);
    }

    private boolean isRoomClean(Room room) throws DirtyRoomException {
        if (room.isClean()) {
            return true;
        }
        throw new DirtyRoomException();
    }

    private boolean isSizeEnough(Room room, List<Guest> guests) throws RoomToSmallException {
        if (room.getNumberOfPeople() >= guests.size()) {
            return true;
        }
        throw new RoomToSmallException();
    }

    private boolean isAnyAdult(List<Guest> guests) throws NoAdultGuestException {
        for (Guest guest : guests) {
            if (isAdult(guest.getDateOfBirth())) {
                return true;
            }
        }
        throw new NoAdultGuestException();

    }

    private boolean isAdult(LocalDate date) {
        return date.isBefore(LocalDate.now().minusYears(YEARS_TO_ADULTS));
    }


    private List<Room> createRoomsList() {
        return new ArrayList<>();
    }

    private void takeAvailableRoom(List<Room> freeRooms) {
        for (Room room : hotel.getRoomsInHotel()) {
            if (room.isAvailable() && room.isClean()) {
                freeRooms.add(room);
            }
        }
    }

    private Room getRoom(int roomNumber) {
        return hotel.getRoomsInHotel().get(roomNumber - 1);
    }

    private boolean isRoomFree(Room room) {
        return room.isAvailable();
    }

    private void setReservation(Room room) {
        room.setAvailable(false);
    }

    private void accommodateGuests(Room room, List<Guest> guests) {
        room.setGuestList(guests);
    }

    private void releaseTheRoom(Room room) {
        room.setAvailable(true);
        checkOutGuests(room);
        makeRoomDirty(room);
    }

    private void makeRoomDirty(Room room) {
        room.setClean(false);
    }


    private void checkOutGuests(Room room) {
        room.setGuestList(null);
    }

    public Hotel getHotel() {
        return hotel;
    }
}
