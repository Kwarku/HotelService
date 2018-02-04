package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.model.domain.Hotel;

public class CreateHotel {
    public static Hotel makeNewHotel() {
        Hotel hotel = new Hotel("RadisonBlue", CreateAddress.makeNewAddress());
        hotel.setRoomsInHotel(CreateRooms.makeSomeRooms());

        return hotel;
    }
}
