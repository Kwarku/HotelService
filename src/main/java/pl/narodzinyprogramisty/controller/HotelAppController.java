package pl.narodzinyprogramisty.controller;

import pl.narodzinyprogramisty.communications.HotelPresenter;
import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;
import pl.narodzinyprogramisty.utils.CreateGuests;
import pl.narodzinyprogramisty.utils.CreateHotel;

import java.util.List;
import java.util.Scanner;

public class HotelAppController {
    private HotelPresenter messeges = new HotelPresenter();
    private Hotel hotel;

    public void startApp() {
        messeges.greeting();
        hotel = CreateHotel.makeNewHotel();
    }

    public int takeMenuNumberChoose() {
        messeges.menu();
        return takeNumber();
    }

    public void printAllRooms() {
        messeges.printFreeRoom(hotel);

    }

    public void printFreeRooms() {
        messeges.printFreeRoom(hotel);

    }

    public void bookRoom() {
        try {
            messeges.bookRoomInHotel(hotel, getRoomNumber(),
                    getGuests(),
                    getNumberOfNight());
        } catch (RoomToSmallException e) {
            System.out.println(e.toString());
        } catch (NoAdultGuestException e) {
            System.out.println(e.toString());
        } catch (DirtyRoomException e) {
            System.out.println(e.toString());
        }
    }

    public void freeRoom() {
        messeges.freeRoomInHotel(hotel, getRoomNumber());
    }

    public void clearRoom() {
        try {
            messeges.cleanRoomInHotel(hotel, getRoomNumber());
        } catch (NotDirtyRoomException e) {
            System.out.println(e.toString());
        }
    }

    public void aboutHotel() {
        messeges.aboutHotel(hotel);

    }
    public void exit(){
        messeges.farewell();
    }

    public void error() {
        messeges.menuError();

    }

    private int takeNumber() {
        Scanner sc = new Scanner(System.in);
        try {

            return Integer.valueOf(sc.next());
        } catch (NumberFormatException e) {
            //todo dodac logowanie bledu
        }
        return Integer.MIN_VALUE;
    }

    private int getNumberOfNight() {
        messeges.askForNumberOfNights();
        return takeNumber();
    }

    private List<Guest> getGuests() {
        messeges.askForGuestNumber();
        int guestsNumber = takeNumber();
        return CreateGuests.makeSomeGuest(guestsNumber);
    }

    private int getRoomNumber() {
        messeges.askForRoomNumber();
        return takeNumber();
    }

}
