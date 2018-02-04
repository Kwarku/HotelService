package pl.narodzinyprogramisty.view;

import pl.narodzinyprogramisty.model.HotelService;
import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.util.List;
import java.util.Scanner;

public class HotelViewer implements HotelUI {
    private Scanner sc = new Scanner(System.in);
    private HotelService hotelService = new HotelService();

    public void greeting() {
        System.out.println("Hello user. Im hotel room service\n");
    }

    public int menu() {
        System.out.printf("\nWhat you want\n%d. show all rooms\n" +
                        "%d. show all free rooms\n" +
                        "%d. book room\n" +
                        "%d. free your room\n" +
                        "%d. call cleaning service to clean some room\n" +
                        "%d. information about the hotel\n" +
                        "%d. close program\n" +
                        "Enter what you want : ",
                Menu.ALL.number,
                Menu.FREE.number,
                Menu.BOOK_ROOM.number,
                Menu.FREE_ROOM.number,
                Menu.CLEAN_ROOM.number,
                Menu.ABOUT_HOTEL.number,
                Menu.CLOSE.number);
        return takeNumber();
    }

    public void farewell() {
        System.out.println("Tanks for your visit. Goodbye. Have a nice day.");
    }

    public void menuError() {
        System.out.println("Error,  pick some else menu element");
    }

    public void error(String msg) {
        System.out.println(msg);
    }

    public void aboutHotel(Hotel hotel) {
        System.out.println("About hotel : " + hotel.toString());
    }

    public void printAllRooms(Hotel hotel) {
        printedRooms(hotelService.getAllRooms(hotel));
    }

    public void printFreeRoom(Hotel hotel) {
        printedRooms(hotelService.getAllAvailableRooms(hotel));

    }

    private void printedRooms(List <Room> list) {
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

    public void bookRoomInHotel(Hotel hotel, int roomNumber, List <Guest> guests, int numberOfNights) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        if (hotelService.bookRoom(hotel, roomNumber, guests, numberOfNights)) {
            System.out.printf("Room %d is yours to %d night", roomNumber, numberOfNights);
        } else {
            System.out.printf("menuError, room %d is booked", roomNumber);
        }
    }

    public void freeRoomInHotel(Hotel hotel, int roomNumber) {
        if (hotelService.makeRoomEmpty(hotel, roomNumber)) {
            System.out.printf("Success, room %d is free now", roomNumber);
        } else {
            System.out.printf("menuError, room %d is not booked", roomNumber);
        }
    }

    public void cleanRoomInHotel(Hotel hotel, int roomNumber) throws NotDirtyRoomException {
        if (hotelService.makeRoomClean(hotel, roomNumber)) {
            System.out.printf("the room nr %d is clean now, you can book it", roomNumber);
        } else {
            System.out.printf("Error, room %d cant be cleaning. We so sorry. Please book other room", roomNumber);
        }
    }

    public int askForRoomNumber() {
        System.out.println("Enter number of room");
        return takeNumber();
    }

    public int askForGuestNumber() {
        System.out.println("Enter number of guests");
        return takeNumber();
    }

    public int askForNumberOfNights() {
        System.out.println("How many nights do you want to rent this room");
        return takeNumber();
    }


    private int takeNumber() {
        return sc.nextInt();
    }
}
