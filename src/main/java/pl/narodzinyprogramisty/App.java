package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.communications.HotelPresenter;
import pl.narodzinyprogramisty.communications.Menu;
import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;
import pl.narodzinyprogramisty.utils.CreateGuests;
import pl.narodzinyprogramisty.utils.CreateHotel;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HotelPresenter messages = new HotelPresenter();
        Hotel hotel1 = CreateHotel.makeNewHotel();

        int userChoose;
        int roomNumber;
        int guests;
        List<Guest> guestList;


        messages.greeting();

        do {
            messages.menu();
            userChoose = scanner.nextInt();

            switch (Menu.getMenu(userChoose)) {

                case ALL: {
                    messages.printAllRooms(hotel1);
                    break;
                }
                case FREE: {
                    messages.printFreeRoom(hotel1);
                    break;
                }
                case BOOK_ROOM: {
                    messages.askForRoomNumber();
                    roomNumber = scanner.nextInt();
                    messages.askForGuestNumber();
                    guests = scanner.nextInt();
                    guestList = CreateGuests.makeSomeGuest(guests);
                    try {
                        messages.bookRoomInHotel(hotel1, roomNumber, guestList);
                    } catch (NoAdultGuestException e) {
                        System.out.println(e.toString());
                    } catch (RoomToSmallException e) {
                        System.out.println(e.toString());
                    }
                    break;
                }
                case FREE_ROOM: {
                    messages.askForRoomNumber();
                    roomNumber = scanner.nextInt();
                    messages.freeRoomInHotel(hotel1, roomNumber);
                    break;
                }
                case CLOSE: {
                    messages.farewell();
                    break;
                }
                case ABOUT_HOTEL: {
                    messages.aboutHotel(hotel1);
                    break;
                }
                case OTHER: {
                    messages.menuError();
                    break;
                }
            }

        } while (userChoose != 0);

    }
}
