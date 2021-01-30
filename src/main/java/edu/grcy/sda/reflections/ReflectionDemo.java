package edu.grcy.sda.reflections;

import edu.grcy.sda.interfaces.multiExtending.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    /**
     * Refleksja pozwala podglądać definicje klas w trakcie działania programu
     * Pozwala też uzależnić działanie programu od tego jaka klasa go wykonuje
     * Dodatkowo pozwala modyfikować działanie klas, metod już w trakcie działania
     *
     */

    public static void main(String[] args) {
        try {
            Class<?> studentClass = Class.forName("edu.grcy.sda.reflections.StudentRef");


            System.out.println("GetDeclaredMethods listuje wszystkie metody danej klasy, łącznie z prywatnymi");
            System.out.println("Sprawdzamy metody klasy StudentRef");
            Method[] classMethods = studentClass.getDeclaredMethods();
            for (Method classMethod : classMethods) {
                System.out.println(classMethod);
            }
            System.out.println("================================");
            System.out.println("GetMethods listuje metody z klasy i jej przodków ale tylko publiczne");
            System.out.println("Sprawdzamy metody klasy StudentRef i jej przodków");
            Method[] allMethods = studentClass.getMethods();
            for (Method method : allMethods) {
                System.out.println(method);
            }

            System.out.println("================================");
            System.out.println("GetDeclaredFields listuje pola z klasy");
            System.out.println("Sprawdzamy pola klasy StudentRef");
            Field[] classFields = studentClass.getDeclaredFields();
            for (Field field : classFields) {
                System.out.println(field);
            }

            System.out.println("================================");
            System.out.println("GetFields listuje pola z klasy i jej przodków ale tylko publiczne");
            System.out.println("Sprawdzamy pola klasy StudentRef i jej przodków");
            Field[] allFields = studentClass.getFields();
            for (Field field : allFields) {
                System.out.println(field);
            }

            System.out.println("================================");
            System.out.println("Robimy obiekt za pomocą wywołań refleksji");
            StudentRef studentRef = (StudentRef) studentClass.getDeclaredConstructor().newInstance();
            Method setNameMethod = studentClass.getDeclaredMethod("setName", String.class);
            Method getNameMethod = studentClass.getDeclaredMethod("getName");
            setNameMethod.invoke(studentRef, "Mariola");
            System.out.println(getNameMethod.invoke(studentRef));

            System.out.println("StudentRef powołany refleksyjnie, ale jest do niego normalny dostęp");
            System.out.println("bo to normalny obiekt");
            studentRef.setSurname("Zimejko");
            System.out.println(studentRef.getName() + " " + studentRef.getSurname());
            Method getAllUniversityInfoMethod = studentClass.getDeclaredMethod("getAllUniversityInfo");

            /**
             * Dostęp do metody prywatnej trzeba "otworzyć"
             */
            getAllUniversityInfoMethod.setAccessible(true);

            System.out.println(getAllUniversityInfoMethod.invoke(studentRef));

        } catch (ClassNotFoundException e) {
            //nie znaleziono klasy
            e.printStackTrace();
        } catch (InstantiationException e) {
            //nie można utworzyć obiektu klasy
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            //nie można wywołać metody (metoda jest ale błąd wywołania)
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            //nie ma takiej metody
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            //nieprawidłowe żądanie dostępu do metody
            e.printStackTrace();
        }

    }

}
