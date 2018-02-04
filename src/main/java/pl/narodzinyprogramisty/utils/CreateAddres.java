package pl.narodzinyprogramisty.utils;

import pl.narodzinyprogramisty.model.domain.Address;

public class CreateAddres {
    public static Address makeNewAddres(){
        return new Address("pl.Rodła", "15B", (short) 2,
                "75-385", "Szczecin", "Poland");
    }
}
