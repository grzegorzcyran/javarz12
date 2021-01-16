package edu.grcy.sda.tests.tdd;

public class StringCalculator {

    public int add(String values){

        if(values.isEmpty()) {
            return 0;
        }

        String[] entries = values.split(",");
        int result = 0;

        for (String entry : entries) {
            result += Integer.parseInt(entry);
        }

        return result;
    }
}
