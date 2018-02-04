package pl.narodzinyprogramisty;

import org.junit.Before;
import org.junit.Test;
import pl.narodzinyprogramisty.buissnesLogic.HotelService;
import pl.narodzinyprogramisty.data.Guest;
import pl.narodzinyprogramisty.data.Hotel;
import pl.narodzinyprogramisty.data.Room;
import pl.narodzinyprogramisty.exceptions.DirtyRoomException;
import pl.narodzinyprogramisty.exceptions.NoAdultGuestException;
import pl.narodzinyprogramisty.exceptions.RoomToSmallException;
import pl.narodzinyprogramisty.utils.CreateHotel;
import pl.narodzinyprogramisty.utils.CreateRooms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HotelServiceTest {
    private Hotel hotel;
    private HotelService hotelService;
    private List<Room> rooms;
    private List<Guest> guests;

    @Before

    public void start() {
        hotelService = new HotelService();
        hotel = CreateHotel.makeNewHotel();
        guests.add(new Guest("Anna", "Lewandowska", LocalDate.of(1985, 1, 15)));
        rooms = new ArrayList<>();
    }

    @Test
    public void getAllRoomsTest() {
        //When
        rooms.addAll(hotelService.getAllRooms(hotel));
        assertEquals(CreateRooms.MAX_RANGE_OF_ROOM, rooms.size());
    }

    @Test
    public void getAllAvailableRoomsTest() {

    }

    @Test
    public void bookRoomTest() throws DirtyRoomException, NoAdultGuestException, RoomToSmallException {


        assertTrue(hotelService.bookRoom(hotel, 1, guests, 1));

    }

    @Test
    public void makeRoomEmptyTest() {

    }

    @Test
    public void makeRoomCleanTest() {

    }

}
