package pl.narodzinyprogramisty.controller;

import pl.narodzinyprogramisty.model.HotelService;
import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;

public class HotelServiceController {
    private HotelService hotelService = new HotelService();

    public List<Room> getRooms(Hotel hotel) {
        return hotelService.getAllRooms(hotel);
    }

    public List<Room> getAvailableRooms(Hotel hotel) {
        return hotelService.getAllAvailableRooms(hotel);
    }

    public boolean bookedRoom(Hotel hotel, int roomNumber, List<Guest> guests, int numberOfNights) throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        return hotelService.bookRoom(hotel, roomNumber, guests, numberOfNights);
    }

    public boolean emptyRoom(Hotel hotel, int roomNumber) {
        return hotelService.makeRoomEmpty(hotel, roomNumber);
    }

    public boolean cleanRoom(Hotel hotel, int roomNumber) throws NotDirtyRoomException {
        return hotelService.makeRoomClean(hotel, roomNumber);
    }
}
