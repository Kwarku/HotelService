package pl.narodzinyprogramisty.communications;

import pl.narodzinyprogramisty.buissnesLogic.HotelService;
import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;

import java.util.List;

public class HotelPresenter implements HotelUI {
    private HotelService hotelService = new HotelService();

    public void greeting() {
        System.out.println("Hello user. Im hotel room service\n");
    }

    public void menu() {
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
        printedRooms(hotelService.getAllAvailableRooms(hotel));

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

    public void bookRoomInHotel(Hotel hotel, int roomNumber, List<Guest> guests) throws NoAdultGuestException, RoomToSmallException, DirtyRoomException {
        if (hotelService.bookRoom(hotel, roomNumber, guests)) {
            System.out.printf("Room %d is yours now", roomNumber);
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

    public void cleanRoomInHotel(Hotel hotel, int roomNumber) throws NotDirtyRoomException{
        if (hotelService.makeRoomClean(hotel, roomNumber)){
            System.out.printf("the room nr %d is clean now, you can book it",roomNumber);
        }else {
            System.out.printf("Error, room %d cant be cleaning. We so sorry. Please book other room");
        }
    }

    public void askForRoomNumber() {
        System.out.println("Enter number of room");
    }

    @Override
    public void askForGuestNumber() {
        System.out.println("Enter number of guests");
    }


}
