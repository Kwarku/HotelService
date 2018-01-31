package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;

import java.util.List;

public interface HotelServiceLogic {

    List<Room> getAllRooms(Hotel hotel);

    List<Room> getAllFreeRooms(Hotel hotel);

    boolean bookRoom(Hotel hotel, int number);

    boolean freeRoom(Hotel hotel, int number);
}
