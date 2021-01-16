package edu.grcy.sda.tests;

public class Utils {

    public char[] everyNthChar(char[] sourceArray, int n) {

        if(sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }

        int returnedLength = sourceArray.length / n;
        char[] resultArray = new char[returnedLength];
        int index = 0;

        for(int i = n-1; i < sourceArray.length; i += n) {
            resultArray[index] = sourceArray[i];
            index++;
        }
        return resultArray;
    }

    public String removePairs(String source) {

        if(source.length() < 2) {
            return source;
        }

        /**
         * String - wykorzystuje obszar pamięi StringPool, nie podlega niszczeniu przez GC
         *
         * StringBuilder - wprowadzony później - do aplikacji jednowątkowych, szybszy od StringBuffera
         *
         * StringBuffer - od Javy 1.0 - bezpieczny w środowisku wielowątkowym - ale przez to wolniejszy
         */

        StringBuilder stringBuilder = new StringBuilder();
        char[] string = source.toCharArray();

        for(int i = 0; i < string.length - 1; i++) {
            System.out.println(string[i]);
            if(string[i] != string[i+1]) {
                stringBuilder.append(string[i]);
            }
        }

        System.out.println(string[string.length - 1]);
        stringBuilder.append(string[string.length - 1]);

        return stringBuilder.toString();
    }
 }
