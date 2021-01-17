package edu.grcy.sda.java8.lambdas;

public class LambdaSamples {
    public static void main(String[] args) {
        /**
         * Lambda (wyrażenie lambda lub funkcja lambda)
         * postać () -> {}
         * gdzie
         * () - może ale nie musi zawierać parametry
         * -> operator pomiędzy parametrami a kodem do wykonania
         * {} - zawierają kod do wykonania, czasem kod można
         * zapisać bez tych klamr
         */
        String first = "aaa";
        String second = "bbb";

        /**
         * robimy implementację interfejsu StringAdding
         * wyrażenie poniżej odnosi się do metody abstrakcyjnej
         * z interfejsu
         */
        //brak typów przy określaniu parametrów
        StringAdding adding = (a, b) -> {return a + b;};

        //określone typy parametrów
        StringAdding addingOneSign = (String a, String b) -> {return a.substring(0,1) + " " + b.substring(0,1);};

        //określone typy parametrów ale brak return, nawiasów klamrowych
        StringAdding addingOneSignNoReturn = (String a, String b) -> a.substring(0,1) + " " + b.substring(0,1);

        //
        StringAdding addingOneSignWithMoreInfo = (String a, String b) -> {
            System.out.println("Ze środka lambdy wieloliniowej");
            return a.substring(0,1) + " " + b.substring(0,1);
        };

        System.out.println("==================");
        System.out.println(adding.add(first, second));
        System.out.println("==================");
        System.out.println(addingOneSign.add(first, second));
        System.out.println("==================");
        System.out.println(addingOneSignNoReturn.add(first, second));
        System.out.println("==================");
        System.out.println(addingOneSignWithMoreInfo.add(first, second));
        System.out.println("==================");

        //postać powyżej i poniżej są dokładnie tym samym
        //działają tak samo, różnią się sposobem zapisu
        StringAdding anotherAdding = new StringAdding() {
            @Override
            public String add(String arg1, String arg2) {
                return arg1 + arg2;
            }
        };

        //Thread PRE Java 8
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Doing some multithreading stuff");
            }
        });
        thread.start();

        //Thread Since Java8
        Thread lambdaThread = new Thread(() -> {
            System.out.println("Lambda style generated thread");
        });
        lambdaThread.start();

        IntMultiplication multi = (x, y) -> x * y;
        System.out.println("==============");
        System.out.println("Testing another method");
        System.out.println(multi.multiply(12, 4));
    }
}
