package pl.narodzinyprogramisty.model.domain;

public class Address {
    private String street;
    private String streetNumber;
    private short number;
    private String postCode;
    private String city;
    private String country;

    public Address(String street, String streetNumber, short number, String postCode, String city, String country) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.number = number;
        this.postCode = postCode;
        this.city = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String toString() {
        return String.format("%s %s/%d, %s %s. %s",
                street,
                streetNumber,
                number,
                postCode,
                city,
                country);
    }
}
