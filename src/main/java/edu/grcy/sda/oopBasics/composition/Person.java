package edu.grcy.sda.oopBasics.composition;

public class Person {
    private String firstName;
    private String lastName;

    //pola adresowe, będziemy mieć problem jak osoba będzie mieć
    //kilka adresów
//    private String street;
//    private String city;
//    private String country;

    private Address homeAddress;
    private Address workAddress;
    private Address schoolAddress;


    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void addHomeAddress(String street, String city, String country) {
        this.homeAddress = new Address(street, city, country);
    }

//    public String getAddress() {
//        return street + " " + city + " " + country;
//    }


    public Address getHomeAddress() {
        return homeAddress;
    }
}
