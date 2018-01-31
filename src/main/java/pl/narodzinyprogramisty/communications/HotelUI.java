package pl.narodzinyprogramisty.communications;

import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;

import java.util.List;

public interface HotelUI extends UI {
    void printList(List<Room> list);
    void bookRoomInHotel(Hotel hotel, int roomNumber);
    void freeRoomInHotel(Hotel hotel, int roomNumber);
    void askForRoomNumber();
}

