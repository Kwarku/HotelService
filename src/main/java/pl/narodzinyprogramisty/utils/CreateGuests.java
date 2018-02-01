package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.data.Guest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateGuests {
    private static Random random = new Random();

    private static String[] names = {"Paweł", "Asia", "Michał", "Kasia", "Aleksander", "Basia", "Marcin", "Aleksandra", "Eustachy", "Balbina"};
    private static String[] lastNames = {"Duda", "Kukiz", "Lewandowski", "Carlos", "Błaszczykowski", "Majkut", "Gates", "Kowalski", "Nowak"};
    private static String[] birthdays = {"1998-05-07", "2002-09-25", "2014-11-17", "1948-11-01","1986-05-17", "2007-09-15", "1983-11-02", "1935-04-01"};

    public static List<Guest> makeSomeGuest(int size) {
        List<Guest> guests = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            guests.add(new Guest(randomName(), randomLastNAme(), randomData()));
        }
        return guests;
    }

    private static int getRandomNumber(int size) {
        return random.nextInt(size);
    }

    private static LocalDate randomData() {
        return LocalDate.parse(birthdays[getRandomNumber(birthdays.length)]);
    }

    private static String randomLastNAme() {
        return lastNames[getRandomNumber(lastNames.length)];
    }

    private static String randomName() {
        return names[getRandomNumber(names.length)];
    }
}
