package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements HotelServiceLogic {
    private static final int YEARS_TO_ADULTS = 18;

    public List<Room> getAllRooms(Hotel hotel) {
        List<Room> rooms = createRoomsList();
        rooms.addAll(hotel.getHotelRoomService());
        return rooms;
    }


    public List<Room> getAllAvailableRooms(Hotel hotel) {
        List<Room> availableRooms = createRoomsList();
        takeAvailableRoom(hotel, availableRooms);
        return availableRooms;
    }


    public boolean bookRoom(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        if (isItRoomAreGood(hotel, number, guests)) {
            setReservation(hotel, number);
            accommodateGuests(hotel, number, guests);
            return true;
        }
        return false;
    }


    public boolean makeRoomEmpty(Hotel hotel, int number) {
        if (!isRoomFree(hotel, number)) {
            releaseTheRoom(hotel, number);
            return true;
        }
        return false;
    }

    public boolean makeRoomClean(Hotel hotel, int number) throws NotDirtyRoomException {
        if (isRoomDirty(hotel, number)) {
            cleanRoom(hotel, number);
            return true;
        }
        throw new NotDirtyRoomException();
    }

    private boolean isRoomDirty(Hotel hotel, int number) {
        return !getRoom(hotel, number).isClean();
    }

    private void cleanRoom(Hotel hotel, int number) {
        getRoom(hotel, number).setClean(true);
    }

    private boolean isItRoomAreGood(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        return isRoomFree(hotel, number) && isAnyAdult(guests) && isSizeEnough(hotel, number, guests) && isRoomClean(hotel, number);
    }

    private boolean isRoomClean(Hotel hotel, int number) throws DirtyRoomException {
        if (getRoom(hotel, number).isClean()){
            return true;
        }
        throw new DirtyRoomException();
    }

    private boolean isSizeEnough(Hotel hotel, int number, List<Guest> guests) throws RoomToSmallException {
        if (getRoom(hotel, number).getNumberOfPeople() >= guests.size()){
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

    private void takeAvailableRoom(Hotel hotel, List<Room> freeRooms) {
        for (Room room : hotel.getHotelRoomService()) {
            if (room.isAvailable() && room.isClean()) {
                freeRooms.add(room);
            }
        }
    }

    private Room getRoom(Hotel hotel, int index) {
        return hotel.getHotelRoomService().get(index - 1);
    }

    private boolean isRoomFree(Hotel hotel, int index) {
        return getRoom(hotel, index).isAvailable();
    }

    private void setReservation(Hotel hotel, int index) {
        getRoom(hotel, index).setAvailable(false);
    }

    private void accommodateGuests(Hotel hotel, int index, List<Guest> guests) {
        getRoom(hotel, index).setGuestList(guests);
    }

    private void releaseTheRoom(Hotel hotel, int index) {
        getRoom(hotel, index).setAvailable(true);
        checkOutGuests(hotel, index);
        makeRoomDirty(hotel, index);
    }

    private void makeRoomDirty(Hotel hotel, int index) {
        getRoom(hotel, index).setClean(false);
    }


    private void checkOutGuests(Hotel hotel, int index) {
        getRoom(hotel, index).setGuestList(null);
    }


}
