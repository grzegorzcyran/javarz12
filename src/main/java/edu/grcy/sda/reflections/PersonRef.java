package edu.grcy.sda.reflections;

public class PersonRef {
    public int age;
    private String gender;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    protected String getDetailedGenderInfo() {
        return gender.equals("Kobieta") ? " Kobiety górą " : "Mężczyźni górą";
    }

    String getAgeSummary() {
        return age >= 18 ? "Dorosły" : "Co Ty wiesz o życiu?";
    }

    private String ageHelper() {
        return age > 75 ? "Może pomóc" : "Dasz radę";
    }
}
