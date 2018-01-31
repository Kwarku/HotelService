package pl.narodzinyprogramisty.buissnesLogic;

import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;

import java.util.ArrayList;
import java.util.List;

public class HotelService implements HotelServiceLogic {


    public List<Room> getAllRooms(Hotel hotel) {
        List<Room> rooms = createRoomsList();
        rooms.addAll(hotel.getHotelRoomService());
        return rooms;
    }


    public List<Room> getAllFreeRooms(Hotel hotel) {
        List<Room> freeRooms = createRoomsList();
        takeOnlyFreeRooms(hotel, freeRooms);
        return freeRooms;
    }


    public boolean bookRoom(Hotel hotel, int number) {
        if (isRoomFree(hotel, number)) {
            setReservation(hotel, number);
            return true;
        }
        return false;
    }


    public boolean freeRoom(Hotel hotel, int number) {
        if (!isRoomFree(hotel, number)) {
            cancelReservation(hotel, number);
            return true;
        }
        return false;
    }


    private List<Room> createRoomsList() {
        return new ArrayList<Room>();
    }

    private void takeOnlyFreeRooms(Hotel hotel, List<Room> freeRooms) {
        for (Room room : hotel.getHotelRoomService()) {
            if (room.isAvailable()) {
                freeRooms.add(room);
            }
        }
    }

    private boolean isRoomFree(Hotel hotel, int index) {
        return hotel.getHotelRoomService().get(index-1).isAvailable();
    }

    private void setReservation(Hotel hotel, int index) {
        hotel.getHotelRoomService().get(index-1).setAvailable(false);
    }

    private void cancelReservation(Hotel hotel, int index) {
        hotel.getHotelRoomService().get(index-1).setAvailable(true);
    }


}
