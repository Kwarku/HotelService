package pl.narodzinyprogramisty.communications;

import pl.narodzinyprogramisty.data.Hotel;

public interface HotelUI extends UI {

    void aboutHotel(Hotel hotel);

    void printAllRooms(Hotel hotel);

    void printFreeRoom(Hotel hotel);

    void bookRoomInHotel(Hotel hotel, int roomNumber);

    void freeRoomInHotel(Hotel hotel, int roomNumber);

    void askForRoomNumber();
}

