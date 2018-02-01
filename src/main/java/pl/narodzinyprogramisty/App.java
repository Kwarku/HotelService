package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.communications.HotelPresenter;
import pl.narodzinyprogramisty.communications.Menu;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.utils.CreateHotel;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HotelPresenter messages = new HotelPresenter();
        Hotel hotel1 = CreateHotel.makeNewHotel();

        int userChoose;
        int roomNumber;


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
                    break;
                }
                case ABOUT_HOTEL:{
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
