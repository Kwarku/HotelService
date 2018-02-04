package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.model.domain.Hotel;

public class CreateHotel {
    public static Hotel makeNewHotel() {
        return new Hotel("RadisonBlue", CreateAddres.makeNewAddres());
    }
}
