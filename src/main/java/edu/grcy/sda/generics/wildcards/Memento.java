package edu.grcy.sda.generics.wildcards;

public class Memento {
    private Note note;

    public Memento(Note note) {
        this.note = note;
    }

    public String getInfo() {
        return note.getNote();
    }
}
