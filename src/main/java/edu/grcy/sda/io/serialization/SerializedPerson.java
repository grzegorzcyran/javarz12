package edu.grcy.sda.io.serialization;

import java.io.Serializable;

public class SerializedPerson implements Serializable {
    private transient int id; //transient oznacza że pole ma nie podlegać serializacji
    private String name;
    private String surname;
    private int age;

    public SerializedPerson(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        //StringBuffer - to samo co StringBuilder ale do pracy
        //wielowątkowej, no i przez to wolniejszy
        return new StringBuffer(surname)
                .append(" ")
                .append(name)
                .toString();
    }

    @Override
    public String toString() {
        return "SerializedPerson{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
