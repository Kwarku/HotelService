package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.util.List;

public interface HotelServiceLogic {

    List<Room> getAllRooms(Hotel hotel);

    List<Room> getAllFreeRooms(Hotel hotel);

    boolean bookRoom(Hotel hotel, int number, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException;

    boolean freeRoom(Hotel hotel, int number);
}
