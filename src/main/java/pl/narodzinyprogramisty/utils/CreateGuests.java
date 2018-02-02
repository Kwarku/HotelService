package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.data.Guest;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateGuests {
    private static Random random = new Random();

    private static String[] names = {"Paweł", "Asia", "Michał", "Kasia", "Aleksander", "Basia", "Marcin", "Aleksandra", "Eustachy", "Balbina"};
    private static String[] lastNames = {"Duda", "Kukiz", "Lewandowski", "Carlos", "Błaszczykowski", "Majkut", "Gates", "Kowalski", "Nowak"};

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

    private static LocalDate randomData(){
        Month month = Month.of(getRandomNumber(12) + 1);
        int day = getRandomNumber(month.getValue()) + 1;
        int year = Year.now().minusYears(getRandomNumber(100)).getValue();
        return LocalDate.of(year, month, day);
    }

    private static String randomLastNAme() {
        return lastNames[getRandomNumber(lastNames.length)];
    }

    private static String randomName() {
        return names[getRandomNumber(names.length)];
    }
}
