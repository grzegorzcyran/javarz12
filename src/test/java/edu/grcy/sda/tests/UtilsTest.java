package edu.grcy.sda.tests;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    Utils utils;

    @BeforeAll //używany rzadziej, raczej testy integracyjne
    public static void commonSetup() {
        System.out.println("CommonSetup called once per class");
    }

    @BeforeEach // używany częściej
    public void setup() {
        System.out.println("Set new object for every test");
        utils = new Utils();
    }

    @Test
    public void testRemovePairs() {
        //given
        String expected = "ABCDEFG";
        String toCheck = "AABCCDEFFG";

        //when
        String result = utils.removePairs(toCheck);

        //then
        //assertEquals(expected, result);
        assertEquals(expected, result, "Result not as expected");
    }

    @Test
    public void testEveryNthChar() {
        char[] expected = new char[]{'a', 'b'};
        char[] toCheck = new char[]{'l', 'a', 'b', 'a'};

        char[] result = utils.everyNthChar(toCheck, 2);

        //assertArrayEquals(expected, result);
        assertArrayEquals( expected, result, "Array not as expected");
    }


    @AfterEach //używany częściej
    public void teardown() {
        System.out.println("After each test");
        utils.toString();
    }

    @AfterAll //używany rzadziej, raczej testy integracyjne
    public static void afterAllTests() {
        System.out.println("AfterAll run once after all tests");
    }



}