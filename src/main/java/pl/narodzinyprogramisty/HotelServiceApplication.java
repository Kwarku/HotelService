package pl.narodzinyprogramisty;

import pl.narodzinyprogramisty.communications.Menu;
import pl.narodzinyprogramisty.controller.HotelAppController;

public class HotelServiceApplication {
    public static void main(String[] args) {
        HotelAppController app = new HotelAppController();

        int userChoose;
        app.startApp();

        do {
            //todo dodac pytanie czy uzytkownik dalej chce uzywac menu
            userChoose = app.takeMenuNumberChoose();
            switch (Menu.getMenu(userChoose)) {
                case ALL:
                    app.printAllRooms();
                    break;
                case FREE:
                    app.printFreeRooms();
                    break;
                case BOOK_ROOM:
                    app.bookRoom();
                    break;
                case FREE_ROOM:
                    app.freeRoom();
                    break;
                case CLEAN_ROOM:
                    app.clearRoom();
                    break;
                case ABOUT_HOTEL:
                    app.aboutHotel();
                    break;
                case CLOSE:
                    app.exit();
                    break;
                case OTHER:
                    app.error();
                    break;

            }
        } while (userChoose != 0);
    }
}
