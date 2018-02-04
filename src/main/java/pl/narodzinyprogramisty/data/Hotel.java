package pl.narodzinyprogramisty.data;

import pl.narodzinyprogramisty.utils.CreateRooms;

import java.util.List;

public class Hotel {
    private String hotelName;
    private Address hotelAddress;

    private List<Room> roomsInHotel;

    public Hotel(String hotelName, Address hotelAddress) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;

        roomsInHotel = CreateRooms.makeSomeRooms();
    }



    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Address getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(Address hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public List<Room> getRoomsInHotel() {
        return roomsInHotel;
    }

    public void setRoomsInHotel(List<Room> roomsInHotel) {
        this.roomsInHotel = roomsInHotel;
    }

    @Override
    public String toString() {
        return String.format("%s, %s. Number of rooms: %d", hotelName, hotelAddress, roomsInHotel.size());
    }
}
