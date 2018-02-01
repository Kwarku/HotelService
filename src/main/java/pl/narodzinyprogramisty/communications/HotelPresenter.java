package pl.narodzinyprogramisty.communications;

import pl.narodzinyprogramisty.buissnesLogic.HotelService;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;

import java.util.List;

public class HotelPresenter implements HotelUI {
    private HotelService hotelService = new HotelService();

    public void greeting() {
        System.out.println("Hello user. Im hotel room service\n");
    }

    public void menu() {
        System.out.printf("\n\nWhat you want\n%d. show all rooms\n" +
                        "%d. show all free rooms\n" +
                        "%d. book room\n" +
                        "%d. free your room\n" +
                        "%d. information about the hotel\n" +
                        "%d. close program\n" +
                        "Enter what you want : ",
                Menu.ALL.number,
                Menu.FREE.number,
                Menu.BOOK_ROOM.number,
                Menu.FREE_ROOM.number,
                Menu.ABOUT_HOTEL.number,
                Menu.CLOSE.number);
    }

    public void farewell() {
        System.out.println("Tanks for your visit. Goodbye. Have a nice day.");
    }

    public void menuError() {
        System.out.println("Error,  pick some else menu element");
    }


    public void aboutHotel(Hotel hotel) {
        System.out.println("About hotel : " + hotel.toString());
    }

    public void printAllRooms(Hotel hotel) {
        printedRooms(hotelService.getAllRooms(hotel));
    }

    public void printFreeRoom(Hotel hotel) {
        printedRooms(hotelService.getAllFreeRooms(hotel));

    }

    private void printedRooms(List<Room> list) {
        int temp = 0;
        for (Room room : list) {
            temp++;
            System.out.println(room);
            if (temp == 5) {
                System.out.println();
                temp = 0;
            }
        }
    }

    public void bookRoomInHotel(Hotel hotel, int roomNumber) {
        if (hotelService.bookRoom(hotel, roomNumber)) {
            System.out.printf("Room %d is yours now", roomNumber);
        } else {
            System.out.printf("menuError, room %d is booked", roomNumber);
        }
    }

    public void freeRoomInHotel(Hotel hotel, int roomNumber) {
        if (hotelService.freeRoom(hotel, roomNumber)) {
            System.out.printf("Success, room %d is free now", roomNumber);
        } else {
            System.out.printf("menuError, room %d is not booked", roomNumber);
        }
    }

    public void askForRoomNumber() {
        System.out.println("Enter number of room");
    }


}
