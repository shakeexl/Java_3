package ru.geekbrains.Level_3.Lesson_6.ArrayHandler;

import java.util.ArrayList;
import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> myList = new ArrayList<>(asList(1, 2, 4, 4, 2, 3, 4, 1, 7));
        ArrayList<Integer> myNewList = new ArrayList<>(asList(1, 4, 4, 1, 1, 4, 3));

        System.out.println(ArrayHandler.arrayHandler(myList));
        System.out.println(ArrayHandler.anotherArrayHandler(myNewList));
    }
}
