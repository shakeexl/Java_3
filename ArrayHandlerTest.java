package ru.geekbrains.Level_3.Lesson_6.ArrayHandler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayHandlerTest {

    private ArrayHandler arrayHandler;

    private ArrayList<Integer> firstTestList = new ArrayList<>(asList(4, 5, 1, 7, 9));
    private ArrayList<Integer> secondTestList = new ArrayList<>(asList(9, 7, 5, 1, 4));
    private ArrayList<Integer> thirdTestList = new ArrayList<>(asList(4, 4, 4, 4, 4));
    private ArrayList<Integer> fourthTestList = new ArrayList<>(asList(1, 8, 2, 3, 7,5));

    private ArrayList<Integer> firstResultList = new ArrayList<>(asList(5, 1, 7, 9));
    private ArrayList<Integer> secondResultList = new ArrayList<>(List.of());
    private ArrayList<Integer> thirdResultList = new ArrayList<>(List.of());

    private ArrayList<Integer> first = new ArrayList<>(asList(1, 1, 1, 4, 4, 1, 4, 4));
    private ArrayList<Integer> second = new ArrayList<>(asList(1, 1, 1, 1, 1, 1));
    private ArrayList<Integer> third = new ArrayList<>(asList(4, 4, 4, 4));
    private ArrayList<Integer> fourth = new ArrayList<>(asList(1, 4, 4, 1, 1, 4, 3));

    @Test
    public void whenFirstFour() {
        Assertions.assertEquals(firstResultList, arrayHandler.arrayHandler(firstTestList));
        System.out.println("Actual result: " + arrayHandler.arrayHandler(firstTestList));
        System.out.println("Expected result: " + firstResultList + "\n");
    }

    @Test
    public void whenLastFour() {
        Assertions.assertEquals(secondResultList, arrayHandler.arrayHandler(secondTestList));
        System.out.println("Actual result: " + arrayHandler.arrayHandler(secondTestList));
        System.out.println("Expected result: " + secondResultList + "\n");
    }

    @Test
    public void whenAllFour() {
        Assertions.assertEquals(thirdResultList, arrayHandler.arrayHandler(thirdTestList));
        System.out.println("Actual result: " + arrayHandler.arrayHandler(thirdTestList));
        System.out.println("Expected result: " + thirdResultList + "\n");
    }

    @Test
    public void whenWithoutFour() {
        assertThrows(RuntimeException.class, () -> {
            arrayHandler.arrayHandler(fourthTestList);
        });
        System.out.println("Exception caught" + "\n");
    }

    @Test
    public void whenOneAndFour() {
        Assertions.assertTrue(arrayHandler.anotherArrayHandler(first));
        System.out.println("Actual result: " + arrayHandler.anotherArrayHandler(first));
        System.out.println("Expected result: " + true + "\n");
    }

    @Test
    public void whenOne() {
        Assertions.assertFalse(arrayHandler.anotherArrayHandler(second));
        System.out.println("Actual result: " + arrayHandler.anotherArrayHandler(second));
        System.out.println("Expected result: " + false + "\n");
    }

    @Test
    public void whenFour() {
        Assertions.assertFalse(arrayHandler.anotherArrayHandler(third));
        System.out.println("Actual result: " + arrayHandler.anotherArrayHandler(third));
        System.out.println("Expected result: " + false + "\n");
    }

    @Test
    public void whenAnotherDigit() {
        Assertions.assertFalse(arrayHandler.anotherArrayHandler(fourth));
        System.out.println("Actual result: " + arrayHandler.anotherArrayHandler(fourth));
        System.out.println("Expected result: " + false + "\n");
    }
}
