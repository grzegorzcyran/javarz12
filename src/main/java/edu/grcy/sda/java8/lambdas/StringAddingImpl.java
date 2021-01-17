package edu.grcy.sda.java8.lambdas;

/**
 * jak klasa implementująca interfejs ma w nazwie Impl
 * albo coś podobnego to znaczy że nie ma dla niej dobrej
 * nazwy albo może interfejs jest niepotrzebny
 */
public class StringAddingImpl implements StringAdding {

    @Override
    public String add(String arg1, String arg2) {
        return null;
    }

    /**
     * możemy ale nie musimy przykrywać tej metody
     * bo ma postać domyślną w interfejsie
     */
//    @Override
//    public void someOtherMethodWithBody() {
//
//        System.out.println("Metoda przykryta z klasy");
//    }
}
