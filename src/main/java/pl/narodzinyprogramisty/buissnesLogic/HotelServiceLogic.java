package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelServiceLogic {

    List<Room> getAllRooms(Hotel hotel);

    List<Room> getAllAvailableRooms(Hotel hotel);

    boolean bookRoom(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException;

    boolean makeRoomEmpty(Hotel hotel, int number);

    boolean makeRoomClean(Hotel hotel, int number) throws NotDirtyRoomException, DirtyRoomException;
}
