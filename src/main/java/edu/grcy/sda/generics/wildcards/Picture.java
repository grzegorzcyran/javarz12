package edu.grcy.sda.generics.wildcards;

public class Picture extends Memento {
    private Image image;

    public Picture(Note note, Image image) {
        super(note);
        this.image = image;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " and " + image.getImage();
    }
}
