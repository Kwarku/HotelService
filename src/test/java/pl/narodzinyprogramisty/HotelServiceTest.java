package pl.narodzinyprogramisty;

import org.junit.Before;
import org.junit.Test;
import pl.narodzinyprogramisty.model.HotelService;
import pl.narodzinyprogramisty.model.domain.Address;
import pl.narodzinyprogramisty.model.domain.Hotel;
import pl.narodzinyprogramisty.model.domain.Room;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class HotelServiceTest {
    private HotelService hotelService;
    private Hotel hotel;
    private List<Room> roomInHotel;
    private List<Room> rooms;


    //todo bledny pokoj
    @Before
    public void start() {
        hotelService = new HotelService();
        hotel = createHotel();
        roomInHotel = new ArrayList<>();
        rooms = new ArrayList<>();
        makeHotelRooms();


    }

    //todo zmienic voidy na inne
    private void makeHotelRooms() {
        makeRoomList();
        roomInHotel.addAll(rooms);
        hotel.setRoomsInHotel(roomInHotel);
    }

    private void makeRoomList() {
        for (int i = 0; i < 10; i++) {
            rooms.add(new Room(i, (i + 1), true));
        }
    }

    private Hotel createHotel() {
        return new Hotel("Mariot", new Address("pl.Rodła", "15B", (short) 2,
                "75-385", "Szczecin", "Poland"));
    }

    @Test
    public void getAllRoomsTest() {
        //when
        for (int i = 0; i < roomInHotel.size(); i++) {
            //Then
            assertTrue(roomInHotel.get(i).equals(rooms.get(i)));
        }
    }

    @Test
    public void takeNotAvailableRoomTest() {
        //Given

        for (Room room : roomInHotel) {
            //recznie musimy zarezerwowac ppokoj dodajac liczbe gosci itd
            room.setAvailable(false);

        }
        //when
        //todo zmienic by hotelservice od razu pobieral jakis swoj hotel
        for (Room room : hotelService.getAllAvailableRooms(hotel)) {
            //then
            //ta lista bedzie pusta. room.size == 0
            //fixme to jest bez sensu
            assertNull(room);
        }
    }

    @Test
    public void takeDirtyRoomTest(){
        //Given
        for (Room room : roomInHotel) {
            room.setClean(false);
        }
        //when
        for (Room room : hotelService.getAllAvailableRooms(hotel)) {
            //then
            assertNull(room);
        }
    }

    //is free
    //is any adult
    //is big enought
    @Test
    public void bookRoomTest() {


    }

    @Test
    public void makeRoomEmptyTest() {

    }

    @Test
    public void makeRoomCleanTest() {

    }

}
