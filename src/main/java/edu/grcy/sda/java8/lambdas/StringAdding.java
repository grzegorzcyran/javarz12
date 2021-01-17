package edu.grcy.sda.java8.lambdas;

/**
 * Anotacja @FunctionalInterface oznacza interfejs funkcyjny
 * czyli taki który ma dokładnie jedną metodę abstrakcyjną
 *
 * Dopuszczalne są inne metody w interfejsie ale wtedy muszą mieć
 * domyślną implementację (słowo kluczowe default)
 */
@FunctionalInterface
public interface StringAdding {
    //jedyna abstrakcyjna metoda w interfejsie funkcyjnym
    String add(String arg1, String arg2);

    //jeśli dołożymy kolejną metodę abstrakcyjną to
    //IDE podświetli anotację
    //void testAnotherMethod();

    default void someOtherMethodWithBody() {
        System.out.println("This is default method body from interface");
    }
}
