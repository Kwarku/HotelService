package pl.narodzinyprogramisty.communications;

import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelUI extends UI {

    void aboutHotel(Hotel hotel);

    void printAllRooms(Hotel hotel);

    void printFreeRoom(Hotel hotel);

    void bookRoomInHotel(Hotel hotel, int roomNumber, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException;

    void freeRoomInHotel(Hotel hotel, int roomNumber);

    void cleanRoomInHotel(Hotel hotel, int roomNumber) throws NotDirtyRoomException;

    void askForRoomNumber();

    void askForGuestNumber();
}

