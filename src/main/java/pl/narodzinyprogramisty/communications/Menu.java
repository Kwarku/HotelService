package pl.narodzinyprogramisty.communications;

public enum Menu {
    ALL(1),
    FREE(2),
    BOOK_ROOM(3),
    FREE_ROOM(4),
    ABOUT_HOTEL(5),
    CLOSE(0),
    OTHER(Integer.MIN_VALUE);

    int number;
    Menu(int number) {
        this.number = number;

    }

    public static Menu getMenu(int num){
        for (Menu menu : Menu.values()) {
            if (menu.number == num) {
                return menu;
            }
        }
        return Menu.OTHER;
    }

}
