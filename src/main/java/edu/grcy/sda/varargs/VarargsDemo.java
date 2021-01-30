package edu.grcy.sda.varargs;

public class VarargsDemo {

    public static void main(String[] args) {
        VarargsDemo demo = new VarargsDemo();
        System.out.println(demo.sumAllPassedInts());
        System.out.println(demo.sumAllPassedInts(1));
        System.out.println(demo.sumAllPassedInts(3, 2, 1));
    }

    /**
     * Varargs pozwalają przekazać od 0 do (wiele) wartości tego samego typu
     */
    private int sumAllPassedInts(int... values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }
        return result;
    }

    /**
     * varargs ZAWSZE musi być ostatnim parametrem metody
     */
    private int sumAllPassedOneAlwaysAvailable(int oneValue, int... followingValues) {
        int result = oneValue;
        for (int followingValue : followingValues) {
            result += followingValue;
        }
        return result;
    }

    //poniższsze nie zadziała
    //private int sumAllPassedOneAlwaysAvailable(int... followingValues, int oneValue)

    //może być tylko 1 vararg, bo nie wiadomo kiedy się skończy
    //więc JVM nie wie które przekazane parametry traktować jako do pierwszego
    //a które do drugiego varargsa
    //private void tryTwoVarargs(Integer... integerVarargs, Exception... exceptions)
}