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
        HotelViewer radisonViewer = new HotelViewer();
//        Hotel hotel = CreateHotel.makeNewHotel();
        List <Guest> guestList;
        int roomNumber;
        int numberOfNight;

        int number;
        radisonViewer.greeting();


        do {
            number = radisonViewer.menu();
            switch (Menu.getMenu(number)) {
                case ALL:
                    radisonViewer.printAllRooms();
                    break;
                case FREE:
                    radisonViewer.printAllRooms();
                    break;
                case BOOK_ROOM:
                    try {
                        roomNumber = radisonViewer.askForRoomNumber();
                        guestList = CreateGuests.makeSomeGuest(radisonViewer.askForGuestNumber());
                        numberOfNight = radisonViewer.askForNumberOfNights();
                        radisonViewer.bookRoomInHotel(roomNumber, guestList, numberOfNight);
                    } catch (NoAdultGuestException e) {
                        radisonViewer.error(e.toString());
                    } catch (RoomToSmallException e) {
                        radisonViewer.error(e.toString());
                    } catch (DirtyRoomException e) {
                        radisonViewer.error(e.toString());
                    }
                    break;
                case FREE_ROOM:
                    roomNumber = radisonViewer.askForRoomNumber();
                    radisonViewer.freeRoomInHotel(roomNumber);
                    break;
                case CLEAN_ROOM:
                    try {
                        roomNumber = radisonViewer.askForRoomNumber();
                        radisonViewer.cleanRoomInHotel(roomNumber);
                    } catch (NotDirtyRoomException e) {
                        radisonViewer.error(e.toString());
                    }
                case ABOUT_HOTEL:
                    radisonViewer.aboutHotel();
                    break;
                case CLOSE:
                    radisonViewer.farewell();
                    break;
                case OTHER:
                    radisonViewer.menuError();

            }
        } while (number != 0);
    }
}
