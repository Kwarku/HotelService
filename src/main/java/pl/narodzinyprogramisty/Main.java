package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.utils.CreateGuests;
import pl.narodzinyprogramisty.utils.CreateHotel;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.NotDirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;
import pl.narodzinyprogramisty.view.HotelViewer;
import pl.narodzinyprogramisty.view.Menu;

import java.util.List;

public class Main {
    //todo dopisac klase kotnrolera dla hotelviewr i hotel service
    public static void main(String[] args) {
        HotelViewer viewer = new HotelViewer();
        Hotel hotel = CreateHotel.makeNewHotel();
        List <Guest> guestList;
        int roomNumber;
        int numberOfNight;

        int number;
        viewer.greeting();


        do {
            number = viewer.menu();
            switch (Menu.getMenu(number)) {
                case ALL:
                    viewer.printAllRooms(hotel);
                    break;
                case FREE:
                    viewer.printAllRooms(hotel);
                    break;
                case BOOK_ROOM:
                    try {
                        roomNumber = viewer.askForRoomNumber();
                        guestList = CreateGuests.makeSomeGuest(viewer.askForGuestNumber());
                        numberOfNight = viewer.askForNumberOfNights();
                        viewer.bookRoomInHotel(hotel,roomNumber, guestList, numberOfNight);
                    } catch (NoAdultGuestException e) {
                        viewer.error(e.toString());
                    } catch (RoomToSmallException e) {
                        viewer.error(e.toString());
                    } catch (DirtyRoomException e) {
                        viewer.error(e.toString());
                    }
                    break;
                case FREE_ROOM:
                    roomNumber = viewer.askForRoomNumber();
                    viewer.freeRoomInHotel(hotel, roomNumber);
                    break;
                case CLEAN_ROOM:
                    try {
                        roomNumber = viewer.askForRoomNumber();
                        viewer.cleanRoomInHotel(hotel, roomNumber);
                    } catch (NotDirtyRoomException e) {
                        viewer.error(e.toString());
                    }
                case ABOUT_HOTEL:
                    viewer.aboutHotel(hotel);
                    break;
                case CLOSE:
                    viewer.farewell();
                    break;
                case OTHER:
                    viewer.menuError();

            }
        } while (number != 0);
    }
}
