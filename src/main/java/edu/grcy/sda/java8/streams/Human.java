package edu.grcy.sda.java8.streams;

public class Human implements Comparable<Human> {
    private String name;
    private String surname;
    private int age;
    private Gender gender;

    public Human(String name, String surname, int age, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    public Human(String name, String surname, int age, String genderShortcutPl) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = Gender.getByShortcutPl(genderShortcutPl);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isOver20AndGenderMan() {
        return age > 20 && "M".equals(getGender().getShortcutPl());
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", gender=" + gender.getTranslationPl() +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        return surname.compareTo(o.getSurname());
    }
}
