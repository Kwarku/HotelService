package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.data.Address;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.communications.HotelPresenter;
import pl.narodzinyprogramisty.communications.Menu;
import pl.narodzinyprogramisty.buissnesLogic.HotelService;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoose;
        int roomNumber;

        HotelService hotelService = new HotelService();
        HotelPresenter messages = new HotelPresenter();


        Address radisonAddress = new Address("pl.Rodła", "15B", (short) 2,
                "75-385", "Szczecin", "Poland");
        Hotel hotel1 = new Hotel("RadisonBlue", radisonAddress);

        messages.greeting();

        do {
            messages.menu();
            userChoose = scanner.nextInt();

            switch (Menu.getMenu(userChoose)) {

                case ALL: {
                    messages.printList(hotelService.getAllRooms(hotel1));
                    break;
                }
                case FREE: {
                    messages.printList(hotelService.getAllFreeRooms(hotel1));
                    break;
                }
                case BOOK_ROOM: {
                    messages.askForRoomNumber();
                    roomNumber = scanner.nextInt();
                    messages.bookRoomInHotel(hotel1, roomNumber);
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
                    return;
                }
                case OTHER: {
                    messages.error();
                    break;
                }
            }

        } while (userChoose != 0);


    }
}
