package edu.grcy.sda.interfaces;

public class Programmer implements OOPCoding {
    @Override
    public void codeOOP(String language) {
        System.out.println("It's Object Oriented Language");
        code(language);
    }

    @Override
    public void code(String language) {
        System.out.println("I'm coding in " + language);
    }
}
