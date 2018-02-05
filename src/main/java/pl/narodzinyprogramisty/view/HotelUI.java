package pl.narodzinyprogramisty.view;

import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelUI extends AppUI {

    void aboutHotel();

    void printAllRooms();

    void printFreeRoom();

    void bookRoomInHotel(int roomNumber, List<Guest> guests, int numberOfNights) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException;

    void freeRoomInHotel(int roomNumber);

    void cleanRoomInHotel(int roomNumber) throws NotDirtyRoomException;

}

