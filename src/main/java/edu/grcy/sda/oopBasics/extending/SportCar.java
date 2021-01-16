package edu.grcy.sda.oopBasics.extending;

/**
 * Immutable class - czyli klasa niemutowalna, niezmienialna
 *
 * Bezpieczna w wielowątkowości bo raz zdeklarowany obiekt nie zmienia się
 */
public class SportCar extends Car{
    private int accelerationTo100;

    public SportCar(int accelerationTo100) {
        //super();
        this.accelerationTo100 = accelerationTo100;
    }

    public int getAccelerationTo100() {
        return accelerationTo100;
    }


}
