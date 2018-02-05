package pl.narodzinyprogramisty.controller;

import pl.narodzinyprogramisty.model.HotelService;
import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.CreateHotel;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;

public class HotelServiceController {
    private HotelService hotelService = new HotelService();

    public List<Room> getRooms() {
        return hotelService.getAllRooms();
    }

    public List<Room> getAvailableRooms() {
        return hotelService.getAllAvailableRooms();
    }

    public boolean bookedRoom(int roomNumber, List<Guest> guests, int numberOfNights) throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        return hotelService.bookRoom(roomNumber, guests, numberOfNights);
    }

    public boolean emptyRoom(int roomNumber) {
        return hotelService.makeRoomEmpty(roomNumber);
    }

    public boolean cleanRoom(int roomNumber) throws NotDirtyRoomException {
        return hotelService.makeRoomClean(roomNumber);
    }

    public Hotel showHotel(){
        return hotelService.getHotel();
    }
}
