package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.model.domain.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateRooms {
    private static final int MAX_RANGE_OF_ROOM = 12;
    private static final short ROOMS_NUMBER = 10;

    public static List<Room> makeSomeRooms() {

        List<Room> rooms = new ArrayList<>();
        for (int i = 1; i <= ROOMS_NUMBER; i++) {
            if (i % 2 == 0) {
                rooms.add(new Room((byte) i, takeRandomNumber(), true));
            } else if (i % 3 == 0) {
                rooms.add(new Room((byte) i, takeRandomNumber(), true));
            } else {
                rooms.add(new Room((byte) i, takeRandomNumber(), false));
            }
        }
        return rooms;
    }

    private static byte takeRandomNumber() {
        Random random = new Random();
        byte number;
        do {
            number = (byte) random.nextInt(MAX_RANGE_OF_ROOM);
        } while (number == 0);
        return number;
    }
}
