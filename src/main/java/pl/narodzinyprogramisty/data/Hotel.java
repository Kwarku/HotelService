package pl.narodzinyprogramisty.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hotel {
    private static final int MAX_RANGE_OF_ROOM = 12;
    private static final short ROOMS_NUMBER = 30;

    private String hotelName;
    private Address hotelAddress;

    private List<Room> hotelRoomService = new ArrayList<Room>();

    public Hotel(String hotelName, Address hotelAddress) {
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;

        createRandomRoom();
    }

    private void createRandomRoom() {

        for (int i = 1; i <= ROOMS_NUMBER; i++) {
            if (i % 2 == 0) {
                hotelRoomService.add(new Room((byte) i, takeRandomNumber(), true));
            } else if (i % 3 == 0) {
                hotelRoomService.add(new Room((byte) i, takeRandomNumber(), true));
            } else {
                hotelRoomService.add(new Room((byte) i, takeRandomNumber(), false));
            }
        }
    }

    private byte takeRandomNumber() {
        Random random = new Random();
        byte number;
        do {
            number = (byte) random.nextInt(MAX_RANGE_OF_ROOM);
        } while (number == 0);
        return number;
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

    public List<Room> getHotelRoomService() {
        return hotelRoomService;
    }

    public void setHotelRoomService(List<Room> hotelRoomService) {
        this.hotelRoomService = hotelRoomService;
    }

    //Hotel: Radison blue, adres
    @Override
    public String toString() {

        return String.format("%s, %s", hotelName, hotelAddress);
/*
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelAddress=" + hotelAddress +
                '}';
*/
    }
}
