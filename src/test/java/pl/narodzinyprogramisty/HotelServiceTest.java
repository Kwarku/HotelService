package pl.narodzinyprogramisty;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pl.narodzinyprogramisty.model.HotelService;
import pl.narodzinyprogramisty.model.domain.Address;
import pl.narodzinyprogramisty.model.domain.Guest;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;
import pl.narodzinyprogramisty.utils.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.utils.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.utils.exceptions.RoomToSmallException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelServiceTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    private HotelService hotelService;
    private Hotel hotel;
    private List <Room> roomInHotel;
    private List <Room> rooms;
    private List <Guest> guests;

    @Before
    public void start() {
        guests = new ArrayList <>();
        hotelService = new HotelService();
        hotel = createHotel();


        hotel.setRoomsInHotel(makeHotelRooms());
        guests = makeGuests();

    }

    //todo sprawdzic co gdy bedzie jakis null
    @Test
    public void getAllRoomsTest() {
        //when
        for (int i = 0; i < roomInHotel.size(); i++) {
            //Then
            assertTrue(roomInHotel.get(i).equals(rooms.get(i)));
        }
    }

    @Test
    public void takeBookedRoomTest() {
        //when
        for (Room room : roomInHotel) {
            room.setAvailable(false);
            room.setGuestList(guests);
            room.setCheckInDate(LocalDate.now());
            room.setCheckOutDate(LocalDate.now());
        }

        //then
        assertEquals(0, hotelService.getAllAvailableRooms(hotel).size());
    }

    @Test
    public void takeDirtyRoomTest() {
        //Given
        for (Room room : roomInHotel) {
            room.setClean(false);
        }
        //when
        assertEquals(0, hotelService.getAllAvailableRooms(hotel).size());
    }

    @Test
    public void positiveBookedRoomTest() throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        //when
        for (int i = 1; i < roomInHotel.size(); i++) {
            hotelService.bookRoom(hotel, i, guests, i);

            //then
            assertFalse(hotel.getRoomsInHotel().get(i - 1).isAvailable());
        }
    }

    @Test
    public void roomToSmallToBookTest() throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        //given
        guests.addAll(makeGuests());
        guests.addAll(makeGuests());

        //when
        thrown.expect(RoomToSmallException.class);
        //then
        hotelService.bookRoom(hotel, 1, guests, 1);
    }

    @Test
    public void roomNotFreeWhenBookTest() throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        //When
        roomInHotel.get(0).setAvailable(false);

        //Then
        assertFalse(hotelService.bookRoom(hotel, 1, guests, 1));
    }
//todo sprawdzic co sie stanie gdy gosciem bedzie null

    @Test
    public void anyAdultOnGuestListTest() throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {
        //when
        guests.clear();
        guests.add(new Guest("Bill", "Gates", LocalDate.now()));
        //then
        thrown.expect(NoAdultGuestException.class);
        hotelService.bookRoom(hotel, 1, guests, 1);
    }


    //    @Test
    public void makeRoomEmptyTest() {

    }

    //    @Test
    public void makeRoomCleanTest() {

    }

    private List <Guest> makeGuests() {

        guests.add(new Guest("Pavel", "Kacie", LocalDate.of(1950, 1, 5)));
        return guests;
    }

    private List <Room> makeHotelRooms() {
        roomInHotel = new ArrayList <>();

        roomInHotel.addAll(makeRoomList());
        return roomInHotel;
    }

    private List <Room> makeRoomList() {
        rooms = new ArrayList <>();
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, (i + 1), true));
        }
        return rooms;
    }

    private Hotel createHotel() {
        return new Hotel("Mariot", new Address("pl.Rodła", "15B", (short) 2,
                "75-385", "Szczecin", "Poland"));
    }
}
