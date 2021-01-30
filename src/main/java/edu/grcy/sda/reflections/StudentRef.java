package edu.grcy.sda.reflections;

public class StudentRef extends PersonRef {
    private String name;
    private String surname;
    String university;
    protected String faculty;
    public String studentNo;

    public StudentRef() {
    }

    public StudentRef(String name, String surname) {
        this.name = name;
        this.surname = surname;
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

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    private String getAllUniversityInfo() {
        return university + " " + faculty;
    }

    protected String getAdditionalInfo() {
        return "Student to więcej pije czy się uczy?";
    }

    String getUniversityDetailedInfo() {
        return university.startsWith("Politechnika") ? "Uczelnia techniczna" : "Uczelnia nietechniczna";
    }
}
