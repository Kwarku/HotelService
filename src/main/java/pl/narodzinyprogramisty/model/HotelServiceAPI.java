package pl.narodzinyprogramisty.model;

import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelServiceAPI {

    List<Room> getAllRooms(Hotel hotel);

    List<Room> getAllAvailableRooms(Hotel hotel);

    boolean bookRoom(Hotel hotel, int number, List<Guest> guests, int numberOfNights ) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException;

    boolean makeRoomEmpty(Hotel hotel, int number);

    boolean makeRoomClean(Hotel hotel, int number) throws NotDirtyRoomException, DirtyRoomException;
}
