package pl.narodzinyprogramisty.view;

import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelUI extends AppUI {

    void aboutHotel(Hotel hotel);

    void printAllRooms(Hotel hotel);

    void printFreeRoom(Hotel hotel);

    void bookRoomInHotel(Hotel hotel, int roomNumber, List<Guest> guests, int numberOfNights) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException;

    void freeRoomInHotel(Hotel hotel, int roomNumber);

    void cleanRoomInHotel(Hotel hotel, int roomNumber) throws NotDirtyRoomException;

}

