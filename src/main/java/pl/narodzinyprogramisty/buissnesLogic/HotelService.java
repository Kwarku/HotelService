package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService implements HotelServiceLogic {
    public static final int YEARS_TO_ADULTS = 18;

    public List<Room> getAllRooms(Hotel hotel) {
        List<Room> rooms = createRoomsList();
        rooms.addAll(hotel.getHotelRoomService());
        return rooms;
    }


    public List<Room> getAllFreeRooms(Hotel hotel) {
        List<Room> freeRooms = createRoomsList();
        takeOnlyFreeRooms(hotel, freeRooms);
        return freeRooms;
    }


    public boolean bookRoom(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException {
        if (isItGoodRoom(hotel, number, guests)) {
            setReservation(hotel, number);
            addGuestToRoom(hotel, number, guests);
            return true;
        }
        return false;
    }

    private boolean isItGoodRoom(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException {
        return isRoomFree(hotel, number) && isAnyAdult(guests) && isSizeEnough(hotel, number, guests);
    }

    private boolean isSizeEnough(Hotel hotel, int number, List<Guest> guests) throws RoomToSmallException {
        if (getRoom(hotel, number).getNumberOfPeople() >= guests.size()){
            return true;
        }
        throw new RoomToSmallException();
//        return getRoom(hotel, number).getNumberOfPeople() >= guests.size();
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


    public boolean freeRoom(Hotel hotel, int number) {
        if (!isRoomFree(hotel, number)) {
            cancelReservation(hotel, number);
            moveBackAllGuestsFromRoom(hotel, number);
            return true;
        }
        return false;
    }


    private List<Room> createRoomsList() {
        return new ArrayList<>();
    }

    private void takeOnlyFreeRooms(Hotel hotel, List<Room> freeRooms) {
        for (Room room : hotel.getHotelRoomService()) {
            if (room.isAvailable()) {
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

    private void addGuestToRoom(Hotel hotel, int index, List<Guest> guests) {
        getRoom(hotel, index).setGuestList(guests);
    }

    private void cancelReservation(Hotel hotel, int index) {
        getRoom(hotel, index).setAvailable(true);
    }

    private void moveBackAllGuestsFromRoom(Hotel hotel, int index) {
        getRoom(hotel, index).setGuestList(null);
    }


}
